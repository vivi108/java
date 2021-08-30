package Ex13_2b;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.io.IOException;
import java.io.EOFException;
//import java.util.Scanner;
import java.io.File;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputStream=null;
		String filename="C:\\Users\\82108\\eclipse-workspace\\Ex13_2b\\num.txt";
		int[] original= new int[10];
		int i=0;
		try {
			inputStream= new Scanner(new File(filename));
			while(inputStream.hasNextInt()) {
				original[i]= inputStream.nextInt();
				i++;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+filename);
			System.exit(0);
		}
		inputStream.close();
		
		
		//Write binary file
		String filename_dat="num.dat";
		i=0;
		try {		
			ObjectOutputStream outputStream= new ObjectOutputStream(new FileOutputStream (filename_dat));
			outputStream.writeByte(original[0]);
			int dif= original[i]-original[i+1];
			while(-128<=dif&&dif<=127) {
				outputStream.writeByte(dif);
				i++;
				if(i==9) break;
				dif= original[i]-original[i+1];
			}
			outputStream.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+filename_dat);
			System.exit(0);
		}
		catch(IOException e) {
			System.out.println("Problem with writing the file "+filename_dat);
		}
		//Read Binary file
		try {
			ObjectInputStream inputStream2= new ObjectInputStream(new FileInputStream(filename_dat));
			int aninteger= inputStream2.readByte();
			System.out.println("Read the binary file: "+aninteger);
			int sum= aninteger;
			int dif=0;
			while(-128<=dif&&dif<=127) {
				dif=(int)inputStream2.readByte();
				sum-=dif;
				System.out.println("Read the binary file: "+sum);
			}
			
			inputStream2.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+filename_dat);
			System.exit(0);
		}
		catch(EOFException e) {
			System.out.println("Problem with writing the file "+filename_dat);
			System.out.println("Reached end of the file");
		}
		catch(IOException e) {
			System.out.println("Problem with writing the file "+filename_dat);
		}
		//Read original sequence
		for(int j=0; j<original.length; j++) {
			System.out.println("Original: "+original[j]);
		}
		
	}

}
