package TEMPERATURE;

public class Temperature {
	private double degree;
	public char scale;
	
	//four constructors
	public Temperature(double d) {
		this(d,'C');
	}
	public Temperature(char s) {
		this(0,s);
	}
	public Temperature(double d, char s) {
		degree=d;
		scale=s;
	}
	public Temperature() {
		this(0, 'C');
	}
	
	//two accessor methods
	//f = (9(c/5)+32)
	//c= 5(f-32)/9
	public double getCelsius() {
		if (this.scale=='C') {
			return degree;
			}
		else {
			return Math.round((double)5/9*(degree-32));
		}
	}
	public double getFarhrenheit() {
		if (this.scale=='F') return degree;
		else {
		return Math.round((double)9/5*degree+32);
		}
	}
	
	//Three set methods
	public void setDegree(double f) {
		degree=f;
	}
	public void setScale(char c) {
		scale=c;
	}
	public void setDegreeScale(double f, char c) {
		degree=f;
		scale=c;
	}
	
	//Three comparison methods
	public boolean equal(Temperature other) {
		return (this.degree==other.degree &&this.scale==other.scale);
	}
	public boolean greater(Temperature other) {
		return (this.degree>other.degree &&this.scale==other.scale);
	}
	public boolean less(Temperature other) {
		return (this.degree<other.degree &&this.scale==other.scale);
	}
}
