package Ex14_4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		int age;
		double weight;
		int keepgoing=0;
		ArrayList<Pet> arr = new ArrayList<Pet>();
		Scanner keyboard = new Scanner(System.in);
		
		while(keepgoing>=0) {
			System.out.print("Enter the pet's name: ");
			name= keyboard.next();
			System.out.print("Enter the pet's age: ");
			age = keyboard.nextInt();
			System.out.print("Enter the pet's weight: ");
			weight= keyboard.nextDouble();
			Pet pet= new Pet(name, age, weight);
			System.out.println();
			
			arr.add(pet);

			System.out.print("If you don't want to creat more objects, enter negative integer: ");
			keepgoing=keyboard.nextInt();
		}
		keyboard.close();
		
		Pet[] petarr=new Pet[arr.size()];
		int i=0;
		for(Object obj: arr.toArray()) {
			petarr[i] =(Pet)obj;
			i++;
		}
		
		Arrays.sort(petarr);
		for(int k=0; k<petarr.length; k++) {
			petarr[k].writeOutput();
			System.out.println();
		}
		
	}

}
