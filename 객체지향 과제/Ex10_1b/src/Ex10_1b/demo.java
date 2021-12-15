package Ex10_1b;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] s= new Shape[] {new Rectangle(4,5), new RightTriangle(2,3), new Circle(7), new Circle(5)};
		for(int i=0; i<4; i++) {
			System.out.println(s[i]);
		}
		if(s[3].equals(s[2])) System.out.println("\nequals");
		else System.out.println("\nnot equals");
	}

}
