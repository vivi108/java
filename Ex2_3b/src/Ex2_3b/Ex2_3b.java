package Ex2_3b;
import java.util.Scanner;
public class Ex2_3b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the radius(in inches): ");
		float radius = keyboard.nextFloat();
		float rad = radius/12;
		
		System.out.print("Enter the depth(in feet): ");
		float depth= keyboard.nextFloat();
		
		float volume= (float)(rad*rad*depth*Math.PI);
		float gallon = (float)(volume*7.48);
		
		System.out.println(depth+"-foot well with a radius of "+radius +" inches holds about "+gallon +" gallons of water");
		keyboard.close();
	}

}
