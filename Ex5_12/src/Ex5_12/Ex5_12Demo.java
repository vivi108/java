package Ex5_12;
import java.util.Scanner;
public class Ex5_12Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Ex5_12 demo= new Ex5_12();
		Ex5_12 anotherdemo= new Ex5_12();
		demo.setMPAA("G");
		demo.setName("superman");
		anotherdemo.setName("batman");
		anotherdemo.setMPAA("G");
		
		demo.addRating(1);
		demo.addRating(2);
		demo.addRating(3);
		demo.addRating(1);
		demo.addRating(1);
		demo.addRating(1);
		
		anotherdemo.addRating(5);
		anotherdemo.addRating(3);
		anotherdemo.addRating(4);
		anotherdemo.addRating(5);
		anotherdemo.addRating(4);
		anotherdemo.addRating(4);
		
		
		System.out.println("the movie name= "+demo.getName()+", MPAA rating= "+demo.getMPAA()+", average = "+ demo.getAverage());
		System.out.println("the movie name= "+anotherdemo.getName()+", MPAA rating= "+anotherdemo.getMPAA()+", average = "+ anotherdemo.getAverage());
		if(demo.equals(anotherdemo)) System.out.println("equals");
		else System.out.println("not equals");
		
		keyboard.close();
	}

}
