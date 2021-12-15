package Ex11_2;

public class TimeFormatException extends Exception{
	public TimeFormatException() {
		super("TimeFormatException");
	}
	public TimeFormatException(String s) {
		super(s);
	}
	public static boolean userillegal(String s) {
		if(s.matches("[0-9]{1,2}:[0-9]{1,2}")) {
			String[] time= s.split(":");
			int hour= Integer.parseInt(time[0]);
			int min =Integer.parseInt(time[1]);
			if(0<=hour&&hour<=24&&0<=min&&min<=59) return true;
			else return false;
		
		}
		else return false;
	}
}
