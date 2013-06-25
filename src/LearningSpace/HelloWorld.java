package LearningSpace;

import java.math.BigInteger;;

public class HelloWorld {
	
	private static int sequenceLimit = 100;
	
	private static BigInteger[] sequenceArray = new BigInteger[sequenceLimit];
	
	public static void main(String[] args) {
		
		sequenceArray[0] = new BigInteger("0");
		sequenceArray[1] = new BigInteger("1");
		
		for (int i = 0; i < sequenceLimit; i++) {
			
			System.out.println(i + 1 + ": " + fib(i));
			
		}
		
	}
	
	public static BigInteger fib(int n) {
        if (n < 2) {
           return sequenceArray[n];
        }
        else {
          	return sequenceArray[n] = sequenceArray[n - 1].add(sequenceArray[n - 2]);
        }
	}
	
}

