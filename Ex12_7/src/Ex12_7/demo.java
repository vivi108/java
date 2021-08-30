package Ex12_7;
import java.util.Scanner;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard= new Scanner(System.in);
		System.out.println("Enter the Integer: ");
		int a= keyboard.nextInt();
		FIBBO.Fibonacci(a);
		keyboard.close();
	}

}
