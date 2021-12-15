package mypack;
import java.util.Scanner;
public class pindemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard= new Scanner(System.in);
		System.out.print("Enter the password(5-digits):");
		int fivedigit= keyboard.nextInt();
		PIN demo= new PIN(fivedigit);
		demo.login();
		
		

		
		
		
		
		keyboard.close();
		
	}

}
