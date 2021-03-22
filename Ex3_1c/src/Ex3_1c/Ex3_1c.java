package Ex3_1c;
import java.util.Scanner;
public class Ex3_1c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the letter grade with Uppercase :");
		char grade = keyboard.next().charAt(0);
		
		switch (grade) {
		case 'A':
			System.out.println("gradeValue is 4.0");
			break;
		case 'B':
			System.out.println("gradeValue is 3.0");
			break;
		case 'C':
			System.out.println("gradeValue is 2.0");
			break;
		case 'D':
			System.out.println("gradeValue is 1.0");
			break;
		default:
			System.out.println("gradeValue is 0.0");
			break;
		}
		
		
		keyboard.close();
		
	}

}
