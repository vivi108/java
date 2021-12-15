package Ex14_2a;
import java.util.HashSet;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> intSet = new HashSet<Integer>();
		intSet.add(2);
		intSet.add(7);
		intSet.add(7);
		intSet.add(3);
		HashSetDemo.printSet(intSet);
		intSet.remove(3);
		HashSetDemo.printSet(intSet);
		System.out.println("Set contains 2: "+ intSet.contains(2));
		System.out.println("Set contains 3: "+ intSet.contains(3));
		
	}

}
