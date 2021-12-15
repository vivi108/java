package Ex12_7;

public class FIBBO {
	public static void Fibonacci(int n) {
		for (int i=0; i<n; i++) {
			int k= i+1;
			if(i<=1) {
				System.out.println("Fibonacci # "+ k +" = "+Fibo(i));
			}
			else {
				double d= (double)Fibo(i)/Fibo(i-1);
				System.out.println("Fibonacci # "+ k +" = "+Fibo(i)+"; "+Fibo(i)+"/"+Fibo(i-1)+" = "+d);
			}
		}
	}
	
	
	private static int Fibo(int cnt) {
		if(cnt==0) return 0;
		if(cnt==1||cnt==2) {
			return 1;
		}
		return Fibo(cnt-1)+Fibo(cnt-2);
	}
	
}
