package Ex11_7;

public class Employee extends Person{
	private String SSN=null;
	private double salary=0;
	//constructor
	public Employee() {
		super();
	}
	public Employee(String i, double s, String n) {
		super(n);
		SSN=i;
		salary=s;
	}
	
	//getter & setter
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	//writeOutput
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Social Security num: " + SSN+ " Salary= "+salary);
	}
	
	
}
