package Ex11_4;
import java.util.Scanner;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String input, answer;
		String[] alphabet_m= {"January", "Febuary", "March", "April", "May", "June", "July", "Agust", "September", "October", "November", "December"};
		while(true) {
			System.out.println("Enter date in numerical format:");
			try{
				input= keyboard.next();
				if(!MonthException.userillegal(input)) 
					throw new MonthException();
				if(!DayException.userillegal(input)) 
					throw new DayException();
				String[] num_day= input.split("/");
				int month= Integer.parseInt(num_day[0]);
				int day =Integer.parseInt(num_day[1]);
				System.out.println(alphabet_m[month-1]+" "+num_day[1]);
			}
			catch (MonthException e) {
				System.out.println("Try Again:");
				continue;
			}
			catch(DayException e) {
				System.out.println("Try Again:");
				continue;
			}
			System.out.println("Again?(y/n)");
			answer= keyboard.next();
			if(answer.equals("n")) {
				System.out.println("End of program");
				break;
			}
		}
		
		keyboard.close();
	}

}
