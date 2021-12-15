package Ex10_1b;

public class Circle implements Shape{
	private double radius=0;
	public Circle(double r) {
		radius=r;
	}
	public double getArea() {
		return radius*radius*Math.PI;
	}
	public String toString() {
		return "Radius= "+radius+" Area= "+getArea();
	}
	public boolean equals(Object other) {
		if(!(other!=null&&other instanceof Circle)) return false;
		Circle c= (Circle)other;
		return this.radius==c.radius;
	}
}
