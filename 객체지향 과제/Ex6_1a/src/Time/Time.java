package Time;

public class Time {
	private int hour;
	private int min;
	
	public Time() {
		this.hour=0;
		this.min=0;
	}
	public static boolean isvalid(int h, int m) {
		return (0<=h&&0<=m&&h<=23&&m<=59);
	}
	public void setTime(int h, int m) {
		if(Time.isvalid(h,m)) {
			this.hour=h;
			this.min=m;
		}
		else System.out.println("not valid parameters");
	}
	
	public void setTime2(int h, int m, boolean isPM) {
		if(isPM) {
			h=h+12;
			setTime(h,m);
		}
		else System.out.println("not valid parameters");
	}
	public void print() {
		System.out.println("hour= "+hour+"minute= "+min);
	}
}
