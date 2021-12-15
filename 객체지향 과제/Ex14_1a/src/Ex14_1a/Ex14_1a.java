package Ex14_1a;
import java.util.ArrayList;
public class Ex14_1a {
	public static ArrayList<String> arrayToArrayList(String[] s){
		ArrayList<String> forreturn = new ArrayList<String>();
		for(int i=0; i<s.length; i++) {
			forreturn.add(s[i]);
		}
		return forreturn;
	}
	public static void removeFromArrayList(ArrayList<String> list, String s) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(s)) list.remove(i);
		}
	}
}
