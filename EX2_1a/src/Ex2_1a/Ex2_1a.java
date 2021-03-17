package Ex2_1a;
import java.util.Scanner;
public class Ex2_1a {

	public static void main(String[] args) {
		int num=0;
		System.out.println("Enter the four-ditits number:");
		Scanner keyboard = new Scanner(System.in);
		num = keyboard.nextInt();
		
		int a=0,b=0,c=0,d=0;
		a = num/1000;
		b = (num/100)%10;
		c = (num/10)%10;
		d = num%10;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

	}

}
