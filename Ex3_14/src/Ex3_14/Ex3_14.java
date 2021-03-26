package Ex3_14;
import java.util.Scanner;

public class Ex3_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		float velocity, height=0;
		int bounce=0, time=0;
		System.out.println("(An initial velocity of at least 100 feet per second is a good choice.) ");
		System.out.print("Enter the initial velocity of the ball: ");
		velocity=keyboard.nextFloat();
		while(bounce<5) {
			System.out.println("Time: "+time+ " Height: "+height);
			height+=velocity;
			velocity=velocity-32;
			time++;
			if(height<=0) {
				height*=(-0.5);
				velocity*=(-0.5);
				bounce++;
				System.out.println("Bounce!");
			}
		}
		System.out.println("\nFive Bounces over!");
		keyboard.close();
	}

}
