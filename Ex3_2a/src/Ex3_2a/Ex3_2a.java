package Ex3_2a;
import java.util.Scanner;
public class Ex3_2a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int input, max=-1, min=-1, sum=0,cnt=1;
		double average=-1;
		System.out.print("Enter the integer, if you want to quit the program then enter the negative value");
		
		input = keyboard.nextInt();
		if(input>=0) {
			min=input;
			max=input;
			
		}
		
		while (input>=0) {
			if(input>max) max=input;
			if(input<min) min=input;
			sum +=input;
			System.out.print("Enter the integer, if you want to quit the program then enter the negative value");
			input = keyboard.nextInt();
			cnt++;
		}
		
		if(cnt!=1) {
			average =(sum/(cnt-1));
			System.out.println(" max="+max+" min="+min+" average="+average);
		}
		else System.out.println("First value is negative");
		keyboard.close();
	}

}
