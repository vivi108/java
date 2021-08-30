package Counter;

public class CounterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter demo = new Counter();
		System.out.println("Current count="+ demo.getNum());
		demo.Decrease();
		demo.Decrease();
		demo.Decrease();
		
		System.out.println("Current count="+ demo.getNum());
		
		demo.Increase();
		demo.Increase();
		demo.Increase();
		demo.Increase();
		System.out.println("Current count="+ demo.getNum());
		
		demo.Reset();
		System.out.println("Current count="+ demo.getNum());
		
		
	}

}
