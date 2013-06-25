package LearningSpace;

import java.io.*;
import java.lang.reflect.*;

public class ObjectReflector {
	
	public static void main(String[] args) {
		
		try {
			
			Class reflectedClass = Class.forName("LearningSpace.HelloWorld");
			
			Method[] reflectedClassMethods = reflectedClass.getDeclaredMethods();
			String reflectedClassName = reflectedClass.getSimpleName();
			
			System.out.println("Class: " + reflectedClassName);
			
			for (int i = 0; i < reflectedClassMethods.length; i++) {
				
				Class[] refClassMethodsParams = reflectedClassMethods[i].getParameterTypes();
				StringBuffer paramNames = new StringBuffer();
				
				for (int j = 0; j < refClassMethodsParams.length; j++) {
					if (j > 0)
						paramNames.append(", ");
					paramNames.append(refClassMethodsParams[j].getName());
				}
				
				System.out.println("Method Name: " + reflectedClassMethods[i].getName() + " Modifiers: " + Modifier.toString(reflectedClassMethods[i].getModifiers()) + " Params: " + paramNames);
			}
			
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
}
