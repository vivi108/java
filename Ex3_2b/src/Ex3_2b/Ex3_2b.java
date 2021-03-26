package Ex3_2b;
import java.util.Scanner;
public class Ex3_2b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int input, cnt=1, a=0,b=0,c=0,d=0,f=0;
		
		System.out.print("Enter the integer(0~100), if you want to quit the program then enter the negative value: ");
		input = keyboard.nextInt();
			
		while (input>=0) {
			if(input>=0 &&input<60) f++;
			else if (input>=60 &&input<70) d++;
			else if (input>=70 &&input<80) c++;
			else if (input>=80 &&input<90) b++;
			else if (input>=90 &&input<=100) a++;
			
			System.out.print("Enter the integer(0~100), if you want to quit the program then enter the negative value: ");
			input = keyboard.nextInt();
			cnt++;
			
		}
		
		if(cnt!=1) {
			System.out.println("total count="+(cnt-1)+" Acount:"+a+" Bcount:"+b+" Ccount:"+c+" Dcount:"+d+" Fcount:"+f);
		}
		else System.out.println("First value is negative");
		
		keyboard.close();
	}

}
