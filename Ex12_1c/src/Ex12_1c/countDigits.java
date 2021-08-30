package Ex12_1c;

public class countDigits {
	public static int count(String s) {
		char c= s.charAt(0);
		
		if(Character.isDigit(c)) {
			if(s.length()==1) return 1;
			else return 1+count(s.substring(1));
		}
		else {
			if(s.length()==1) return 0;
			else return count(s.substring(1));
		}
		
	}
}
