package LearningSpace;

import java.lang.reflect.*;

public class MethodInspector {
	
	public static void main(String[] args) {
		
		Class inspect;
		
		try {
			
			inspect = Class.forName("LearningSpace.Threads");
			
			Method[] methods = inspect.getDeclaredMethods();
			
			for (int i = 0; i < methods.length; i++) {
				
				Method methVal = methods[i];
				Class returnVal = methVal.getReturnType();
				String modVal = Modifier.toString(methVal.getModifiers());
				Class[] paramVal = methVal.getParameterTypes();
				StringBuffer params = new StringBuffer();
				
				for (int j = 0; j < paramVal.length; j++) {
					
					if (j > 0)
						params.append(", ");
					params.append(paramVal[j].getName());
					
				}
				
				System.out.println("Method: " + methVal.getName() + "() ");
				System.out.println("Modifiers: " + modVal);
				System.out.println("Return Type: " + returnVal.getName());
				System.out.println("Parameters: " + params + "\n");
				
			}
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error -- " + cnfe.toString());
		}
		
	}
	
}
