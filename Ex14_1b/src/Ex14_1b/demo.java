package Ex14_1b;

import java.util.Scanner;
import java.util.ArrayList;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<Integer> arr= new ArrayList<Integer>();
		int sum=0;
		while(true) {
			System.out.print("Enter the any score, if you want to stop, enter the negative value: ");
			Integer a= keyboard.nextInt();
			if(a<0) break;
			arr.add(a);
			sum+=a;
		}
		
		double average=(double)sum/arr.size();
		System.out.println("Average: "+ average);
		
		System.out.print("all scores above the average: ");
		for(int i=0; i<arr.size();i++) {
			if(arr.get(i)>average) System.out.print(arr.get(i)+" ");
			else continue;
		}
		
		keyboard.close();
	}

}
