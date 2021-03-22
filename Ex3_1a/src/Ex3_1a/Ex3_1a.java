package Ex3_1a;
import java.util.Scanner;
public class Ex3_1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the check amount: ");
		int check = keyboard.nextInt();
		keyboard.close();
		float charge;
		if (check <10) {
			System.out.println("charge = $1");
		}
		else if (check <100) {
			charge = (float)(0.1*check);
			System.out.println("charge = $" +charge);
		}
		else if (check <1000) {
			charge = (float)(0.05*check+5);
			System.out.println("charge = $" +charge);
		}
		else if (check >=1000) {
			charge = (float)(0.01*check+40);
			System.out.println("charge = $" +charge);
		}

	}

}
