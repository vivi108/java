package Ex11_1b;

public class InvalidMinuteException extends InvalidTimeException{
	public InvalidMinuteException() {
		super("InvalidMinuteException");
	}
	public InvalidMinuteException(String m) {
		super(m);
	}
	public static boolean checkMinute(String m) {
		if(m.matches("[0-9]{1,2}")) {
			int mm= Integer.parseInt(m);
			if(0<=mm&&mm<=59) return true;
			else return false;
		}
		else return false;
	}
}
