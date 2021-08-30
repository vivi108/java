package POLYNOMIAL;

public class Polynomial {
	private int degree;
	private double[] coefficients;
	
	public Polynomial(int max) {//constructor
		degree=max+1;
		coefficients= new double[degree];
		for(int i=0; i<coefficients.length; i++) {
			coefficients[i]=0;
		}
	}
	public void setConstant(int i, double value) {
		coefficients[i]= value;
	}
	public double evaluate(double x) {
		double sum=0;
		for(int i=0; i<coefficients.length; i++) {
			sum+= coefficients[i]*Math.pow(x, i);
		}
		return sum;
	}
}
