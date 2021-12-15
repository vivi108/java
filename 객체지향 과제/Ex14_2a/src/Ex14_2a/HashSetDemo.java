package Ex14_2a;
import java.util.HashSet;
public class HashSetDemo {
	public static void printSet(HashSet<Integer> intSet) {
		System.out.println("The set contains");
		for(Object obj : intSet.toArray()) {
			Integer num = (Integer)obj;
			System.out.println(num.intValue());
		}
	}
	
}
