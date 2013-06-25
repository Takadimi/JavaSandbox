package LearningSpace;

import java.io.*;

public class PrimeReader {

	public static void main(String[] args) {
		
		try (FileInputStream file = new FileInputStream("400primes.txt"); BufferedInputStream buff = new BufferedInputStream(file); DataInputStream data = new DataInputStream(buff);) {
			
			try {
				while (true) {
					int in = data.readInt();
					System.out.print(in + " ");
				}
			} catch (EOFException eof) {
				buff.close();
			}
			
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		
	}
	
}