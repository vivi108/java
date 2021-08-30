package Purchase;
import java.util.Scanner;
public class PurchaseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Purchase orange =new Purchase();
		Purchase Eggs =new Purchase();
		Purchase Apples =new Purchase();
		Purchase Watermelon =new Purchase();
		Purchase Bagels =new Purchase();
		
		orange.setName("orange");
		orange.setPrice(10, 2.99);
		orange.setNumberBought(24);
		double orangetotal= orange.getTotalCost();
		
		
		Eggs.setName("egg");
		Eggs.setPrice(12, 1.69);
		Eggs.setNumberBought(36);
		double eggtotal= Eggs.getTotalCost();
		
		
		Apples.setName("apple");
		Apples.setPrice(3, 1);
		Apples.setNumberBought(20);
		double appletotal= Apples.getTotalCost();
		
		
		Watermelon.setName("watermelon");
		Watermelon.setPrice(1, 4.39);
		Watermelon.setNumberBought(2);
		double watermelontotal= Watermelon.getTotalCost();
		
		
		Bagels.setName("Bagels");
		Bagels.setPrice(6, 3.5);
		Bagels.setNumberBought(12);
		double bagelstotal= Bagels.getTotalCost();
		
		double total =orangetotal+eggtotal+appletotal+watermelontotal+bagelstotal;
		
		System.out.println("2 dozens oranges= "+orangetotal);
		System.out.println("3 dozens eggs= "+eggtotal);
		System.out.println("20 apples= "+appletotal);
		System.out.println("2 watermelons= "+watermelontotal);
		System.out.println("1 dozens bagels= "+bagelstotal);
		System.out.println("\nTotal coat= "+total);
		
		keyboard.close();
		
	}

}
