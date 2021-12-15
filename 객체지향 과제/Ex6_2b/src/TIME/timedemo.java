package TIME;

public class timedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time demo = new Time();
		demo.print();
		
		Time setTime2= new Time(10,30,true);
		setTime2.print();
		
		Time setTime1= new Time(15, 40);
		setTime1.print();
		
		System.out.println(setTime1.getTime24());
		System.out.println(setTime1.getTime12());
		
	}

}
