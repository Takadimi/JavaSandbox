package LearningSpace;

import java.io.*;

public class ByteReader {
	
	public static void main(String[] args) {
		
		try (FileInputStream file = new FileInputStream("save.gif")){
			
			boolean eof = false;
			int count = 0;
			while(!eof) {
				int input = file.read();
				System.out.print(input + " ");
				if (input == -1) {
					eof = true;
				} else {
					count++;
				}
				if(count % 15 == 0) {
					System.out.println();
				}
			}
			file.close();
			System.out.println("\nBytes read: " + count);
			
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		
	}
	
}
