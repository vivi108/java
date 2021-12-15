package Ex14_2b;

import java.util.HashSet;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list= {"a", "b", "a", "c", "b"};
		HashSet<String> listToAL=Ex14_2b.arrayToHashSet(list);
		for(Object obj: listToAL.toArray()) {
			String s=(String)obj;
			System.out.println(s.toString());
		}
		System.out.println();
		Ex14_2b.removeFromHashSet(listToAL, "a");
		for(Object obj: listToAL.toArray()) {
			String s=(String)obj;
			System.out.println(s.toString());
		}
	}

}
