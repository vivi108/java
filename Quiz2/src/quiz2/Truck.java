package quiz2;

public class Truck extends Vehicle{
	public final double load, tow;
	private double currentLoad;
	
	//constructor
	public Truck(double l, double t, String s, int n) {
		super( s,  n);
		load=l;
		tow=t;
	}
	
	//getter & setter
	public double getCurrentLoad() {
		return currentLoad;
	}

	public void setCurrentLoad(double current) {
		if(current<=load) this.currentLoad = current;
		else System.out.println("CurrentLoad is over the load capacity");
	}

	//equals, toString, CompareTo;
	public String toString() {
		return "manufacturer_Name= "+super.manufacturer_name+" num of Cylinder= "+ super.numOfcylinders+"Owner= "+this.getOwner().getName()+" Load capacity= "+ this.load+" Tow capacity= "+tow+" Current Load= "+this.getCurrentLoad();
	}
	
	public boolean equals(Truck other) {
		if(!(other!=null)) return false;
		return (load==other.load&&tow==other.tow&&this.getCurrentLoad()==other.getCurrentLoad()&&manufacturer_name.equals(other.manufacturer_name)&&numOfcylinders==other.numOfcylinders&&this.getOwner().getName().equals(other.getOwner().getName()));
	}
	public int compareTo(Object obj) {
		if(!(obj!=null&&obj instanceof Truck)) return 0;
		Truck s= (Truck)obj;
		return (int)(s.load-this.load);
	}

}
