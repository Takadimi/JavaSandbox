package LearningSpace;

import java.io.*;

public class ObjectSerializer {
	
	public static void main(String[] args) {
		
		HelloWorld helloWorld = new HelloWorld();
		
		try {
			
			FileOutputStream fo = new FileOutputStream("HelloWorld.obj");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			
			oo.writeObject(helloWorld);
			oo.close();
			
			System.out.println("Object successfully serialized!");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
}
