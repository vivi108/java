package POLYNOMIAL;

public class polynomialdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial demo= new Polynomial(3);
		demo.setConstant(0, 3);
		demo.setConstant(1, 5);
		demo.setConstant(3, 2);
		System.out.println("If x=2, what is the value of \'3+5x+2x^3\' : "+demo.evaluate(2));
		
		Polynomial demo2= new Polynomial(4);
		demo2.setConstant(0, 3);
		demo2.setConstant(1, 5);
		demo2.setConstant(3, 2);
		demo2.setConstant(4, 1);
		System.out.println("If x=2.5, what is the value of \'3+5x+2x^3+x^4\' : "+demo2.evaluate(2.5));
		
	}

}
