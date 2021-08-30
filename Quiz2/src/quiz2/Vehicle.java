package quiz2;

public abstract class Vehicle implements java.lang.Comparable{
	public final String manufacturer_name;
	public final int numOfcylinders;
	private Person owner;
	
	//constructor with manufacturer name and num of cylinder
	public Vehicle(String s, int n) {
		owner= new Person();
		manufacturer_name=s;
		numOfcylinders=n;
	}
	
	//accessor/mutator methods for owner
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	//equals, toString, CompareTo;
	public abstract int compareTo(Object obj);
	public String toString() {
		return "Name= "+manufacturer_name+" num of Cylinder= "+ numOfcylinders+"Owner= "+this.owner.getName();
	}
	
	public boolean equals(Vehicle other) {
		if(!(other!=null)) return false;
		return (manufacturer_name.equals(other.manufacturer_name)&&numOfcylinders==other.numOfcylinders&&this.getOwner().getName().equals(other.getOwner().getName()));
	}
	
}
