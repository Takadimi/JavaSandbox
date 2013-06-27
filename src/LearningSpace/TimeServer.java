package LearningSpace;

import java.io.*;
import java.net.*;
import java.util.*;

public class TimeServer extends Thread {
	
	private ServerSocket sock;
	
	public TimeServer() {
		
		super();
		try {
			
			sock = new ServerSocket(4415);
			System.out.println("TimeServer running...");
			
		} catch (IOException ioe) {
			System.out.println("Error: Couldn't create socket...");
			System.exit(1);
		}
		
	}
	
	public void run() {
		
		Socket client = null;
		
		while (true) {
			
			if (sock == null) {
				return;
			} 
			
			try {
				client = sock.accept();
				BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
				PrintWriter os = new PrintWriter(bos, false);
				String outLine;
				Date now = new Date();
				os.println(now);
				
				BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
				
				char inLine = (char)bis.read();
				
				System.out.println(inLine);
				
				if (inLine == '1') {
					os.flush();
					os.close();
					client.close();
				}
				
			} catch (IOException ioe) {
				System.out.println("Error: Couldn't connect to client...");
				System.exit(1);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		TimeServer server = new TimeServer();
		server.start();
		
	}
	
}
