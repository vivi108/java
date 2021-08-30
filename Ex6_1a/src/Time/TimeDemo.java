package Time;

public class TimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time demo = new Time();
		demo.print();
		
		int h=10, m=30;
		if(h<=12&&h>=0) demo.setTime2(h,m,true);
		else demo.setTime2(h,m,false);
		demo.print();
		
		demo.setTime(5, 40);
		demo.print();
	}

}
