package Ex2_2;
import java.util.Scanner;
public class Ex2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard =new Scanner(System.in);
		System.out.print("Enter the line :");
		String readLine = keyboard.nextLine();

		int i=0;
		char first = readLine.charAt(i);
		String word="";
		
		for(int j=0; j<readLine.length(); j++) {
			if (first == ' ') break;
			first = readLine.charAt(i);
			i++;
		}
		
		word = readLine.substring(0,i);
		String changeCap = readLine.substring(i,i+1);
		readLine = changeCap.toUpperCase()+readLine.substring(i+1) +" "+ word;
		
		System.out.println(readLine);
		keyboard.close();

	}

}
