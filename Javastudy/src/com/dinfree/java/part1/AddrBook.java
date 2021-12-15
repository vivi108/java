package com.dinfree.java.part1;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class AddrBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File rfile = new File("C:\\addrbook.csv");

		    try{
		    	
	            BufferedReader br = new BufferedReader(new FileReader(rfile));
	            String s;
	            while((s= br.readLine())!=null) {
	            	StringTokenizer st= new StringTokenizer(s, ",");
	            	while(st.hasMoreTokens()) {
	            		System.out.println(st.nextToken());
	            		
	            	}
	            	
	            }
		    }
		    catch (IOException e) {  // This block executed if the file is not found
		        // and then the program exits
		    System.out.println("File not found.");
		    System.exit(0);
		    }

		   
	}

}
