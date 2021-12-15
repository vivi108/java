package Ex10_1c;

public class HazardPay extends PayCalculator{
	public HazardPay(double p) {
		super(p);
	}
	
	public double computePay(double hour) {
		return super.computePay(hour)*1.5;
	}
}
