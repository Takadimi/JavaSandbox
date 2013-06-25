package LearningSpace;

import java.io.*;

public class BufferDemo {

	public static void main(String[] args) {

		int start = 65;
		int finish = 90;

		ArgStream as = new ArgStream(start, finish);
		System.out.println("\nWriting: ");
		as.writeStream();
		System.out.println("\nReading: ");
		as.readStream();

	}

}

class ArgStream {

	int start;
	int finish;

	ArgStream(int st, int fin) {
		start = st;
		finish = fin;
	}

	boolean writeStream() {
		try (FileOutputStream file = new FileOutputStream("numbers.dat"); BufferedOutputStream buff = new BufferedOutputStream(file)) {

			for (int out = start; out <= finish; out++) {
				buff.write(out);
				System.out.print(" " + out);
			}

			buff.close();
			return true;

		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
	}

	boolean readStream() {
		try (FileInputStream file = new FileInputStream("numbers.dat"); BufferedInputStream buff = new BufferedInputStream(file)) {

			int in;
			do {
				in = buff.read();
				if (in != -1) {
					System.out.print(" " + in);
				}
			} while (in != -1);

			buff.close();
			return true;

		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}

	}

}