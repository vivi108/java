package Ex13_1b;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputStream = null;
		String filename="C:\\Users\\82108\\eclipse-workspace\\Ex13_1b\\src\\Ex13_1b\\peoplename.txt";
		try {
			inputStream = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening file name "+filename);
			System.exit(0);
		}
		String name="";
		
		while(inputStream.hasNextLine()) {
			String line= inputStream.nextLine();
			name+=" "+line;
		}
		inputStream.close();
		PrintWriter outputStream=null;
		try {
			outputStream = new PrintWriter("result.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening file name result.txt");
			System.exit(0);
		}
		String[] arr = name.split(" ");
		System.out.println(arr[1]+" "+arr[2]);
		System.out.println(arr[3]+" "+arr[4]);
		System.out.println(arr[5]+" "+arr[6]);
		System.out.println(arr[7]+" "+arr[8]);
		
		outputStream.println(arr[1]+" "+arr[2]);
		outputStream.println(arr[3]+" "+arr[4]);
		outputStream.println(arr[5]+" "+arr[6]);
		outputStream.println(arr[7]+" "+arr[8]);
		outputStream.close();
		
	}

}
