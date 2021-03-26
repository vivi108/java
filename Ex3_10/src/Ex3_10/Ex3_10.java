package Ex3_10;
import java.util.Scanner;
/*reads a bank account balance and an interest rate and displays the value of the account in ten years.
 * When compounded annually, the interest is added once per year at the end of the year. 
 * When compounded monthly, the interest is added 12 times per year. 
 * When computed daily, the interest is added 365 times per year.
 * 
 using a loop that adds in the interest for each time period
  The calculation is repeated until the user asks to end the program
 */
public class Ex3_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int num;
		float account, rate;
		double annually, monthly, daily;
		while(true) {
			System.out.print("if you want to stop program then enter '-1', or put any number: ");
			num=keyboard.nextInt();
			if(num==-1) {
				System.out.println("end");
				break;
				}
			else {
				System.out.print("Enter your bank account balance: ");
				account=keyboard.nextFloat();
				System.out.print("Enter an interest rate: ");
				rate=keyboard.nextFloat();
				annually = account;
				monthly = account;
				daily =account;
				for(int k=0;k<10;k++) {
					annually = annually+annually*rate/100;
					for(int i=0;i<365;i++) {
						daily =daily+daily*rate/365/100;
					}
					for(int j=0;j<12;j++) {
						monthly=monthly+monthly*rate/12/100;
					}
				}
				System.out.println("Values of the account in ten years are");
				System.out.println("Annually= "+annually+" Monthly= "+monthly +" Daily= "+ daily);
				System.out.println("");
			}
			
		}
		keyboard.close();
	}

}
