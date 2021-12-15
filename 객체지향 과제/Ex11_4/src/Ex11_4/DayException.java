package Ex11_4;

public class DayException extends Exception{
	public DayException() {
		super("DayException");
	}
	public DayException(String s) {
		super(s);
	}
	public static boolean userillegal(String s) {
		if(s.matches("[0-9]{1,2}/[0-9]{1,2}")) {
			String[] day= s.split("/");
			int month= Integer.parseInt(day[0]);
			int d= Integer.parseInt(day[1]);
			
			if(month==2&&1<=d&&d<=28) return true;
			else if(month==4||month==6||month==9||month==11) {
				if(1<=d&&d<=30) return true;
				else return false;
			}
			else if(month==1||month==3||month==5||month==7||month==10||month==12||month==8) {
				if(1<=d&&d<=31) return true;
				else return false;
			}
			else return false;
		
		}
		else return false;
	}
}
