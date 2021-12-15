package Ex14_2b;

import java.util.HashSet;

public class Ex14_2b {
	public static HashSet<String> arrayToHashSet(String[] s){
		HashSet<String> forreturn = new HashSet<String>();
		for(int i=0; i<s.length; i++) {
			forreturn.add(s[i]);
		}
		return forreturn;
	}
	public static void removeFromHashSet(HashSet<String> list, String s) {
			if(list.contains(s)) list.remove(s);
	}
}
