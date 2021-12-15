package Ex14_1a;
import java.util.ArrayList;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list= {"a", "b", "a", "c", "b"};
		ArrayList<String> listToAL=Ex14_1a.arrayToArrayList(list);
		for(int i=0; i<listToAL.size(); i++) {
			System.out.print(listToAL.get(i)+" ");
		}
		System.out.println();
		Ex14_1a.removeFromArrayList(listToAL, "a");
		for(int i=0; i<listToAL.size(); i++) {
			System.out.print(listToAL.get(i)+" ");
		}
		
	}

}
