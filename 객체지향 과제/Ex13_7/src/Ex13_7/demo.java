package Ex13_7;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputfilename ="C:\\Users\\82108\\eclipse-workspace\\Ex13_7\\abbreviations.txt";
		Scanner inputStream = null;
		String s="";
		try {
			inputStream= new Scanner(new File(inputfilename));
			while(inputStream.hasNext()) {
				s+=" "+inputStream.next();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+inputfilename);
			System.exit(0);
		}
		inputStream.close();
		String[] abb= s.split(" ");
		
		//readmessage
		Scanner inputStream2 = null;
		String inputfilename2 = "C:\\Users\\82108\\eclipse-workspace\\Ex13_7\\textmessage.txt";
		try {
			inputStream2= new Scanner(new File(inputfilename2));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+inputfilename2);
			System.exit(0);
		}
		
		//Print
		String outputfilename ="withbrackets.txt";
		PrintWriter outputStream = null;
		try {
			outputStream= new PrintWriter(outputfilename);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+outputfilename);
			System.exit(0);
		}
		while(inputStream2.hasNext()) {
			String word= inputStream2.next();
			if(word.charAt(word.length()-1)=='.'||word.charAt(word.length()-1)==','||word.charAt(word.length()-1)=='?'||word.charAt(word.length()-1)=='!') {
				
			
				for(int i=1; i<abb.length; i++) {
					if(abb[i].equalsIgnoreCase(word.substring(0, word.length()-1))) {
						word="<"+word.substring(0, word.length()-1)+">"+word.charAt(word.length()-1);
					}
				}
			}
			else {
				for(int i=1; i<abb.length; i++) {
					if(abb[i].equalsIgnoreCase(word)) {
						word="<"+word+">";
					}
				}
			}
			outputStream.print(word+" ");
			System.out.print(word+ " ");
		}
		inputStream2.close();
		outputStream.close();
	}

}
