package Ex11_1b;

public class InvalidHourException extends InvalidTimeException{
	public InvalidHourException() {
		super("InvalidHourException");
	}
	public InvalidHourException(String m) {
		super(m);
	}
	public static boolean checkHour(String h) {
		if(h.matches("[0-9]{1,2}")) {
			int hh= Integer.parseInt(h);
			if(0<=hh&&hh<=12) return true;
			else return false;
		}
		else return false;
	}
}
