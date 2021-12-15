package Ex4_2a;

public class Ex4_2a {
	public static final double capacitiyofFT=60;
	private int amountofF=5;
	public static final double Maxspeed =120;
	private int Curspeed = 7;
	private double effi= 12;
	
	public int getAmountofF() {
		return amountofF;
	}
	public void setAmountofF(int amountofF) {
		if(amountofF>capacitiyofFT) System.out.println("ERROR: fuel amount is greater than TankCapacity");
		else this.amountofF = amountofF;
	}
	public int getCurspeed() {
		return Curspeed;
	}
	public void setCurspeed(int curspeed) {
		if(Curspeed>Maxspeed) System.out.println("ERROR: Current speed is greater than Max speed");
		else this.Curspeed = curspeed;
	}
	public double getEffi() {
		return effi;
	}
	public void setEffi(double effi) {
		this.effi = effi;
	}
	
	public void printAmountofF(int time) {
		double maxf= effi*Maxspeed*Maxspeed*time;
		double curf= effi*Curspeed*Curspeed*time;
		System.out.println("amount of fuel used at the maximum speed: "+maxf);
		System.out.println("amount of fuel used at the current speed: "+curf);
	}
	public void printTravelDistance(int time) {
		double maxt= Maxspeed*time;
		double curt= Curspeed*time;
		System.out.println("travel distance of the maximum speed: "+maxt);
		System.out.println("travel distance of the current speed: "+curt);
	}
	public void printTravelDistance2() {
		double fin= amountofF/(effi*Curspeed);
		System.out.println("travel distance of the current speed and fuel amount: "+fin);
	}
}
