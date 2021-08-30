package Ex11_1a;

public class InvalidTimeException extends Exception{
	public InvalidTimeException() {
		super("format error");
	}
	public InvalidTimeException(String m) {
		super(m);
	}
	public static boolean checkTime(String t) {
		if(t.matches("[0-9]{1,2}:[0-9]{1,2} (am|pm)")) return true;
		else return false;
	}
}
