package Ex14_2c;

import java.util.LinkedList;


public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list= {"a", "b", "a", "c", "b"};
		LinkedList<String> listToAL=Ex14_2c.arrayToLinkedList(list);
		for(Object obj: listToAL.toArray()) {
			String s=(String)obj;
			System.out.println(s.toString());
		}
		System.out.println();
		Ex14_2c.removeFromLinkedList(listToAL, "a");
		for(Object obj: listToAL.toArray()) {
			String s=(String)obj;
			System.out.println(s.toString());
		}
	
	}

}
