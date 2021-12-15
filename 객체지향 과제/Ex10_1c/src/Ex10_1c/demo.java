package Ex10_1c;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularPay r= new RegularPay(10);
		RegularPay r2= new RegularPay(7.5);
		HazardPay h = new HazardPay(10);
		HazardPay h2 = new HazardPay(7.5);
		
		System.out.println(r.computePay(5));
		System.out.println(r2.computePay(5));
		System.out.println(h.computePay(5));
		System.out.println(h2.computePay(5));
		
	
	}

}
