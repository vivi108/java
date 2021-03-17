package Ex2_3a;
import java.util.Scanner;
public class Ex2_3a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the price of an item in cents(a multiple of 5 between 25 and 100) : ");
		int cent = keyboard.nextInt();
		int change = 100-cent;
		
		int quater = change/25;
		int dime = (change%25)/10;
		int nickel = ((change%25)%10)/5;
		
		System.out.println("for an item of "+cent+ " cents, the change is "+change+" cents, which is given by "+quater+" quaters, "+dime +" dimes, and "+nickel+" nickels");
		
		
		keyboard.close();
	}

}
