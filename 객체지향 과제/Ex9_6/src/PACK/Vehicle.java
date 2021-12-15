package PACK;

public class Vehicle {
	public String name="no name yet";
	public int numOfcylinders=0;
	public Person owner;
	
	//constructors
	public Vehicle() {
		owner= new Person();
	}
	
	public Vehicle(String s, int n) {
		owner= new Person();
		name=s;
		numOfcylinders=n;
	}
	
	public Vehicle(String na, String s, int n) {
		owner= new Person(na);
		name=s;
		numOfcylinders=n;
	}

	
}
