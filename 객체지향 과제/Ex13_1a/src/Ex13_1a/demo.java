package Ex13_1a;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the filename: ");
		Scanner keyboard= new Scanner(System.in);
		String filename= keyboard.next();
		keyboard.close();
		
		PrintWriter output = null;
		try {
			output= new PrintWriter(filename);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+filename);
			System.exit(0);
		}
		
		for(int i=0; i<10; i++) {
			int ran=1+(int)(Math.random()*100);
			output.println(ran);
		}
		output.close();
		Scanner inputStream=null;
		try {
			inputStream= new Scanner(new File(filename));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+filename);
			System.exit(0);
		}
		int[] arr =new int[10];
		int i=0;
		double sum=0;
		System.out.println("Integers in File: ");
		
		while(inputStream.hasNextInt()) {
			arr[i]=inputStream.nextInt();
			System.out.print (arr[i]+" ");
			sum+=arr[i];
			i++;
		}
		System.out.println("");
		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();

		inputStream.close();
		System.out.println("Max= "+max);
		System.out.println("Min= "+min);
		System.out.println("Sum= "+sum);
		System.out.println("Average= "+(double)sum/10);
		
	}

}
