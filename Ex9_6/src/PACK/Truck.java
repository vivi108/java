package PACK;

public class Truck extends Vehicle{
	private double load=0, tow=0;
	//constructor
	public Truck () {
		super();
	}
	public Truck(double l, double t) {
		super();
		load=l;
		tow=t;
	}
	
	//getter & setter
	public double getLoad() {
		return load;
	}
	public void setLoad(double load) {
		this.load = load;
	}
	public double getTow() {
		return tow;
	}
	public void setTow(double tow) {
		this.tow = tow;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
	
	public int getNumOfcylinders() {
		return numOfcylinders;
	}

	public void setNumOfcylinders(int num) {
		numOfcylinders = num;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person own) {
		owner = own;
	}
	
	
	
	
	public String toString() {
		return "Name= "+super.name+" num of Cylinder= "+ super.numOfcylinders+"Owner= "+this.owner.getName()+" Load capacity= "+ this.load+" Tow capacity= "+tow;
	}
	
	//equals
	public boolean equals(Object other) {
		if(!(other!=null&&other instanceof Truck)) return false;
		Truck t=(Truck)other;
		return (t.getLoad()==this.getLoad()&&t.getTow()==this.getTow());
	}
}
