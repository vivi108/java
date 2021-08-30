package Ex11_7;

public class SSNLengthException extends Exception{
	public SSNLengthException() {
		super("SSNLengthException");
	}
	public SSNLengthException(String s) {
		super(s);
	}
	public static boolean illegal(String s) {
	if(s.length()==9) return true;
	else return false;
	}
}
