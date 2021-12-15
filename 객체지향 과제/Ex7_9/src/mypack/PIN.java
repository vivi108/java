package mypack;
import java.util.Scanner;
public class PIN {
	Scanner keyboard= new Scanner(System.in);
	private int[] actualpin= new int[5];
	private int[] num=new int[10];
	private void seperatedigit(int k) {
		actualpin[0]= k/10000;
		actualpin[1]= (k/1000)%10;
		actualpin[2]= (k/100)%10;
		actualpin[3]= (k/10)%10;
		actualpin[4]= k%10;
	}
	public PIN(int k) {
		seperatedigit(k);

	}
	private void resetnum() {
		for(int i=0; i<10;i++) {
			num[i]= (int)(Math.random()*3)+1;
		}
	}
	public void setactualpin(int k) {
		seperatedigit(k);
	}
	private void printscreen() {
		System.out.print("PIN: 0 1 2 3 4 5 6 7 8 9\nNUM:");
		for(int i=0; i<10;i++) {
			System.out.print(" "+num[i]);
		}
		System.out.println();
	}
	public void login() {
		int cnt=0;
		resetnum();
		printscreen();
		
		System.out.println();
		System.out.print("Enter the num that corresponds to PIN(5-digits):");
		int input= keyboard.nextInt();
		
		int[] inputpin= new int[5];
		inputpin[0]= input/10000;
		inputpin[1]= (input/1000)%10;
		inputpin[2]= (input/100)%10;
		inputpin[3]= (input/10)%10;
		inputpin[4]= input%10;
		
		for(int i=0; i<actualpin.length; i++) {
			if(num[actualpin[i]]==inputpin[i]) cnt++;
		}
		
		if(cnt==5) System.out.println("loginSucces");
		else {
			System.out.println("loginFailed");
		}
		
		
		
	}
}
