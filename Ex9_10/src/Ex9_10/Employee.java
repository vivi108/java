package Ex9_10;

public class Employee extends Person{
	private int id=0;
	private String department="NONE";
	//constructor
	public Employee() {
		super();
	}
	public Employee(int i, String d, String n) {
		super(n);
		id=i;
		department=d;
	}
	//getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	//writeOutput
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Employee ID: " + id+ " Department= "+ department);
	}
}
