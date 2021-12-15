package MotorBoat;

public class MotorBoat {
	public int capacitiyofFT=10;
	public int amountofF=5;
	public int Maxspeed =20;
	public int Curspeed = 7;
	public double effi= 12;
	
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
