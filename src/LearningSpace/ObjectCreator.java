package LearningSpace;

import java.io.*;

public class ObjectCreator implements Serializable {
	
	public static void main(String[] args) {
		
		Class serializableClass = Circle.class;
		
		try {
			
			Object serializableClassObject = serializableClass.newInstance();
			
			FileOutputStream fo = new FileOutputStream("Object.obj");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			
			oo.writeObject(serializableClassObject);
			oo.close();
			System.out.println("Object created!");
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}
	
}
