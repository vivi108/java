package TEMPERATURE;

public class temdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Temperature demo = new Temperature(0);
		Temperature demo2 = new Temperature('F');
		Temperature demo3 = new Temperature(10, 'F');
		Temperature demo4 = new Temperature(25);
		
		System.out.println();
		
		System.out.println(demo.getCelsius()+ " degree C");
		System.out.println(demo.getFarhrenheit()+" degree F");
		
		demo.setDegree(-40);
		demo.setDegree(100);
		demo3.setDegreeScale(100, 'C');
		demo2.setScale('C');
		
		System.out.println();
		System.out.println(demo.getCelsius()+ " degree C "+ demo.getFarhrenheit()+" degree F");
		System.out.println(demo2.getCelsius()+ " degree C "+demo2.getFarhrenheit()+" degree F");
		System.out.println(demo3.getCelsius()+ " degree C "+demo3.getFarhrenheit()+" degree F");
		System.out.println(demo4.getCelsius()+ " degree C "+demo4.getFarhrenheit()+" degree F");
		
		System.out.println();
		System.out.println("demo is same as demo4? "+demo.equal(demo4));
		System.out.println("demo2 is greater than demo3? "+demo2.greater(demo3));
		System.out.println("demo3 is less than demo? "+demo3.less(demo));
		System.out.println();
		
		
	}

}
