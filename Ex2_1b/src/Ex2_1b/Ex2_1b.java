package Ex2_1b;
import java.util.Scanner;
public class Ex2_1b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Fahrenheit : ");
		Scanner keyboard = new Scanner(System.in);
		float fahren, cel;
		
		fahren = keyboard.nextFloat();
		cel = 5 *(fahren - 32)/9;
		
		System.out.println("Celsius is "+ cel);

	}

}
