package LearningSpace;

import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.*;

public class FingerServer {
	
	public FingerServer() {
		
		try {
			
			// Create a nonblocking server socket channel
			ServerSocketChannel sockChannel = ServerSocketChannel.open();
			sockChannel.configureBlocking(false);
			
			// Set the host and port to monitor
			InetSocketAddress server = new InetSocketAddress("localhost", 2143);
			ServerSocket socket = sockChannel.socket();
			socket.bind(server);
			
			// Create the selector and register it on the channel
			Selector selector = Selector.open();
			sockChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			// Loop forever, looking for client connections
			while (true) {

				// Wait for connection
				selector.select();
				
				// Get list of selection keys with pending events
				Set keys = selector.selectedKeys();
				Iterator it = keys.iterator();
				
				// Handle each key
				while (it.hasNext()) {
					
					// Get the key and remove it from the iteration
					SelectionKey selKey = (SelectionKey) it.next();
					
					it.remove();
					if (selKey.isAcceptable()) {
						
						// Create a socket connection with the client
						ServerSocketChannel selChannel = (ServerSocketChannel) selKey.channel();
						ServerSocket selSocket = selChannel.socket();
						Socket connection = selSocket.accept();
						
						// Handle the finger request
						handleRequest(connection);
						connection.close();
						
					}
					
				}
				
			}
			
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		
	}
	
	private void handleRequest(Socket connection) throws IOException {
		
		// Set up input and output
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader is = new BufferedReader(isr);
		PrintWriter pw = new PrintWriter(new BufferedOutputStream (connection.getOutputStream()), false);
		
		// Output server greeting
		pw.println("Nio Finger Server");
		pw.flush();
		
		// Handle User Input
		String outLine = null;
		String inLine = is.readLine();
		
		if (inLine.length() > 0) {
			outLine = inLine;
		}
		
		readPlan(outLine, pw);
		
		// Clean up
		pw.flush();
		pw.close();
		is.close();
		
	}
	
	private void readPlan(String userName, PrintWriter pw) {
		
		try {
			
			FileReader file = new FileReader(userName + ".plan");
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			
			pw.println("\nUser name: " + userName + "\n");
			
			while(!eof) {
				
				String line = buff.readLine();
				
				if (line == null) {
					eof = true;
				} else {
					pw.println(line);
				}
				
			}
			
			buff.close();
			
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		FingerServer nio = new FingerServer();
	}
	
}
