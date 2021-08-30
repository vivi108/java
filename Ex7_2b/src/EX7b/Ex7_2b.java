package EX7b;

public class Ex7_2b {
	public static double getSum(double[][] arr, int row) {
		double sum=0;
		for(int i=0; i<arr[row].length; i++ ) {
			sum+= arr[row][i];
		}
		return sum;
	}
	public static double getAverage(double[][] arr, int column) {
		double sum=0;
		double average=0;
		for(int i=0; i<arr.length; i++) {
			sum+= arr[i][column];
		}
		average= sum/arr.length;
		return average;
	}
}
