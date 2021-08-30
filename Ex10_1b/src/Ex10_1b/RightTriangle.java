package Ex10_1b;


public class RightTriangle implements Shape {
	private double height=0, width=0;
	//constructor
	public RightTriangle(double h,double w) {
		height=h;
		width=w;
	}
	
	public double getArea() {
		return height*width;
	}
	public String toString() {
		return "Height= "+ height+"Width= "+ width+"Area= "+ getArea();
	}
	public boolean equals(Object other) {
		if(!(other!=null&&other instanceof RightTriangle)) return false;
		RightTriangle r= (RightTriangle)other;
		return this.height==r.height&&this.width==r.width;
	}
}
