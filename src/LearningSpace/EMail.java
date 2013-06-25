package LearningSpace;

import java.io.*;

public class EMail implements Serializable {
	
	private String message = "";
	
	public EMail(String message) {
		
		this.message = message;
		
	}
	
	public String getMessage() {
		return message;
	}
	
}
