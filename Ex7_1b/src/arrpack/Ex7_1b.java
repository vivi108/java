package arrpack;
import java.util.Scanner;
public class Ex7_1b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		int[] frequency = new int[10];
		int a;

		String quit;
		String phone;
		while(true) {
			System.out.println("Start the program from now, if you want to quit, then enter quit: ");
			quit = keyboard.next();
			for(int i=0; i<frequency.length; i++) {
				frequency[i]=0;
			}
			
			if(quit.equals("quit")) break;
			else {
				
				System.out.println("-------------------------");
				System.out.println();
				keyboard.nextLine();
				System.out.print("Enter the any phone num: ");
				phone= keyboard.nextLine();
				
		
				String s= new String();
				for(int i=0; i<phone.length(); i++) {
					Character c= phone.charAt(i);
					if(Character.isDigit(c)) {
						s= c.toString();
						a= Integer.parseInt(s);
						for(int j=0; j<frequency.length; j++) {
							if(a==j) frequency[j]++;
							else continue;
						}
					}	
					else continue;
				}
				System.out.println();
		
				for(int i=0; i<frequency.length; i++) {
				System.out.println("frequency["+i+"]= "+frequency[i]);
				}
				System.out.println();
				System.out.println("-------------------------");
			}
		
		}
		
		keyboard.close();
	
	}

}
