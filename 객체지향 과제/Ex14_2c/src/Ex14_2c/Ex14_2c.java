package Ex14_2c;

import java.util.LinkedList;

public class Ex14_2c {
	public static LinkedList<String> arrayToLinkedList(String[] s){
		LinkedList<String> forreturn = new LinkedList<String>();
		for(int i=0; i<s.length; i++) {
			forreturn.add(s[i]);
		}
		return forreturn;
	}
	public static void removeFromLinkedList(LinkedList<String> list, String s) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(s)) list.remove(i);
		}
	}
}
