package Ex11_4;

public class MonthException extends Exception{
	public MonthException() {
		super("MonthException");
	}
	public MonthException(String s) {
		super(s);
	}
	public static boolean userillegal(String s) {
		if(s.matches("[0-9]{1,2}/[0-9]{1,2}")) {
			String[] day= s.split("/");
			int month= Integer.parseInt(day[0]);
			if(1<=month&&month<=12) return true;
			else return false;
		
		}
		else return false;
	}
}
