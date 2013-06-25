package LearningSpace;

import java.io.*;

public class ObjectReader {
	
	public static void main(String[] args) {
		
		try {
			
			FileInputStream fi = new FileInputStream("Object.obj");
			ObjectInputStream oi = new ObjectInputStream(fi);
			Circle circle = (Circle) oi.readObject();
			
			oi.close();
			
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
		}
		
	}
	
}
