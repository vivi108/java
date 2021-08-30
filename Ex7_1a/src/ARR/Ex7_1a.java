package ARR;
import java.util.Scanner;
public class Ex7_1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the any int for length of array: ");
		int num= keyboard.nextInt();
		
		int[] arr = new int[num];
		int sum=0;
		for(int i=0; i<arr.length;i++) {
			System.out.print("Enter the any score: ");
			arr[i]= keyboard.nextInt();
			sum+=arr[i];
		}
		double average=(double)sum/arr.length;
		System.out.println("Average: "+ average);
		
		System.out.print("all scores above the average: ");
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>average) System.out.print(arr[i]+" ");
			else continue;
		}
		
		keyboard.close();
	}

}
