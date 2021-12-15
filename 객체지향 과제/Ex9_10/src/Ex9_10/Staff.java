package Ex9_10;

public class Staff extends Employee{
	private int paygrade=1;//1-20
	//constructor
	public Staff() {
		super();
	}
	public Staff(int p) {
		super();
		paygrade=p;
	}
	public Staff(int p,int i, String d, String n) {
		super(i,d,n);
		paygrade=p;
	}
	//getter & setter
	public int getPaygrade() {
		return paygrade;
	}
	public void setPaygrade(int paygrade) {
		this.paygrade = paygrade;
	}
	//write
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Paygrade: " + paygrade);
	}
}
