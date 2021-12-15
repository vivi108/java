package Ex12_1d;

public class checkPalindrome {
	public static boolean checkpalindrome(String s) {
		String reverse="";
		for(int i=s.length()-1; i>=0;i--) {
			reverse+=s.charAt(i);
		}
		if(checkAlphabet(s).equals(checkAlphabet(reverse))) return true;
		else return false;
	}

	
	private static String checkAlphabet(String s) {
		char c= s.charAt(0);
		
		if(Character.isAlphabetic(c)) {
			if(s.length()==1) return s;
			else return checkAlphabet(s.substring(1));
		}
		else {
			if(s.length()==1) return null;
			else return checkAlphabet(s.substring(1));
		}
	}
}
