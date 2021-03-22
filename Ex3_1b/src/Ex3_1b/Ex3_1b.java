package Ex3_1b;
import java.util.Scanner;
public class Ex3_1b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the price of an item in cents(a multiple of 5 between 25 and 100) : ");
		int cent = keyboard.nextInt();
		if (cent <25 || cent%5!=0 || cent >100) System.out.println("Input value is Wrong Form");
		else {
			int change = 100-cent;
			int quater = change/25;
			int dime = (change%25)/10;
			int nickel = ((change%25)%10)/5;
			System.out.println("for an item of "+cent+ " cents, the change is "+change+" cents, which is given by "+quater+" quaters, "+dime +" dimes, and "+nickel+" nickels");
		
		}
		keyboard.close();
	}

}
