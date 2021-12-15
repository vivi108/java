package Ex10_1c;

public abstract class PayCalculator {
	private double payRate=0;
	
	public PayCalculator(double p) {
		payRate=p;
	}
	public double computePay(double hour) {
		return payRate*hour;
	}
	
	public double getPayRate() {
		return payRate;
	}
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
}