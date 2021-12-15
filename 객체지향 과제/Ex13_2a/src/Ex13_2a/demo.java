package Ex13_2a;


import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.EOFException;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the filename: ");
		Scanner keyboard= new Scanner(System.in);
		String filename= keyboard.next();
		keyboard.close();
		
		int cnt=0;
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
			do {
			
			int ran=1+(int)(Math.random()*100);
			output.writeInt(ran);
			cnt++;
			}while(cnt<10);
			output.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+filename);
			System.exit(0);
		}
		catch(IOException e) {
			System.out.println("Problem with output to file"+filename);
		}
		
		
	
		int aninteger;
		int[] arr =new int[10];
		int i=0;
		double sum=0;
		try {
			ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream(filename));
			System.out.println("Integers in File: ");
			aninteger=inputStream.readInt();
			while(aninteger>=0) {
				arr[i]=aninteger;
				System.out.print (arr[i]+" ");
				sum+=arr[i];
				i++;
				aninteger=inputStream.readInt();
			}
			inputStream.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("\nError opening name "+filename);
			System.exit(0);
		}
		catch(EOFException e) {
			System.out.println("\nProblem with reading to file"+filename);
			System.out.println("Reached end of the file");
		}
		catch(IOException e) {
			System.out.println("\nProblem with reading to file"+filename);
		}
		
		
		System.out.println("");
		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();

		System.out.println("Max= "+max);
		System.out.println("Min= "+min);
		System.out.println("Sum= "+sum);
		System.out.println("Average= "+(double)sum/10);
	}

}
