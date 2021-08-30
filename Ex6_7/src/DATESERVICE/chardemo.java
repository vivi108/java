package DATESERVICE;
import java.util.Scanner;
public class chardemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard= new Scanner(System.in);
		Characteristic demo= new Characteristic("optimistic");
		System.out.println(demo.getDescription());
		System.out.println("Enter the rating value");
		int ratevalue= keyboard.nextInt();
		demo.setRating(ratevalue);
		System.out.println(" ");
		
		Characteristic demo1= new Characteristic("negative");
		System.out.println(demo1.getDescription());
		System.out.println("Enter the rating value");
		ratevalue= keyboard.nextInt();
		demo1.setRating(ratevalue);
		System.out.println(" ");
		
		Characteristic demo2= new Characteristic("optimistic");
		System.out.println(demo2.getDescription());
		System.out.println("Enter the rating value");
		ratevalue= keyboard.nextInt();
		demo2.setRating(ratevalue);
		System.out.println(" ");

		System.out.println("demo, demo1 = "+demo.getRating()+" "+demo1.getRating());
		System.out.println(demo.getCompitability(demo1));
		System.out.println("demo, demo2 = "+demo.getRating()+" "+demo2.getRating());
		System.out.println(demo.getCompitability(demo2));
		
		keyboard.close();
		
	}

}
