package Ex11_7;

public class SSNCharacterException extends Exception{
	public SSNCharacterException() {
		super("SSNCharacterException");
	}
	public SSNCharacterException(String s) {
		super(s);
	}
	public static boolean illegal(String s) {
		int cnt=0;
		for(int i=0; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) 
				cnt++;
		}
		if(cnt==9) return true;
		else return false;
		
	}
}
