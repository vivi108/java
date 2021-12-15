package Ex14_18;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.print("Enter the key, if you want to end, enter -1: ");
		int a=keyboard.nextInt();
		while(a>=0) {
			arr.add(a);
			System.out.print("Enter the key, if you want to end, enter -1: ");
			a=keyboard.nextInt();
		}
		keyboard.close();
		System.out.println();
		for(int i=0; i<arr.size(); i++) {
			int cnt=0;
			for(int j=0; j<arr.size(); j++) {
			if(arr.get(i) == arr.get(j)) cnt++;
			} hash.put(arr.get(i), cnt);		
		}
		
		//overwrites the old!!
		for(Integer i : hash.keySet()) {
			System.out.println("The number "+i+" occurs " + hash.get(i)+" times");
		}
	}

}
