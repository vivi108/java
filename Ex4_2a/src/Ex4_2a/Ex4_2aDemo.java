package Ex4_2a;

public class Ex4_2aDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_2a demo = new Ex4_2a();
		int time = 85;
		System.out.println("Fuel Amount: " +demo.getAmountofF());
		System.out.println("Current speed: " +demo.getCurspeed());
		System.out.println("Efficienty: " +demo.getEffi());
		System.out.println("");
		demo.printAmountofF(time);
		demo.printTravelDistance(time);
		demo.printTravelDistance2();
		System.out.println("");
		demo.setCurspeed(3);
		demo.setAmountofF(15);
		demo.setEffi(10);
		System.out.println("Fuel Amount: " +demo.getAmountofF());
		System.out.println("Current speed: " +demo.getCurspeed());
		System.out.println("Efficienty: " +demo.getEffi());
		System.out.println("");
		demo.printAmountofF(time);
		demo.printTravelDistance(time);
		demo.printTravelDistance2();
	}

}
