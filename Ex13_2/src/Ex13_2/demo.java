package Ex13_2;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the file name for reading the numbers: ");
		String inputfilename=keyboard.next();
		//C:\Users\82108\eclipse-workspace\Ex13_2\num.txt
		System.out.println("Enter the file name for writing the numbers: ");
		String outputfilename=keyboard.next();
		
		keyboard.close();
		
		Scanner inputStream= null;
		try {
			inputStream= new Scanner(new File(inputfilename));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+inputfilename);
			System.exit(0);
		}
		
		PrintWriter outputStream = null;
		try {
			outputStream= new PrintWriter(outputfilename);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+outputfilename);
			System.exit(0);
		}
		int old=-1;
		System.out.println("Output list: ");
		while(inputStream.hasNextInt()) {
			int a = inputStream.nextInt();
			if(a==old) continue;
			outputStream.println(a);
			System.out.println(a);
			old =a;
		}

		inputStream.close();
		outputStream.close();
	}

}
