package Ex11_2;
import java.util.Scanner;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String input, answer;
		while(true) {
			System.out.println("Enter time in 24-hour notation:");
			try{
				input= keyboard.next();
				if(!TimeFormatException.userillegal(input)) 
					throw new TimeFormatException();
				String[] time= input.split(":");
				int hour= Integer.parseInt(time[0]);
				int min =Integer.parseInt(time[1]);
				if(hour>=12) {
					hour=hour-12;
					System.out.println(hour+":"+time[1]+" PM");
				}
				else System.out.println(hour+":"+time[1]+" AM");
			}
			catch (TimeFormatException e) {
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
