package Ex3_13;
import java.util.Scanner;
public class Ex3_13 {
/*

First line will have one asterisk, the next two, and so on, with each line having one 
more asterisk than the previous line, up to the number entered by the user. 
On the next line write one fewer asterisk and continue by decreasing the 
number of asterisks by 1 for each successive line until only one asterisk is displayed

If input value is 3 then the result is:
*
**
***
**
*

 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int num, j=0;
		char arisk='*';
		
		System.out.print("Enter the integer: ");
		num= keyboard.nextInt();
		
		for (int i=1; i<=num;i++) {
			
			for(j=0; j<i;j++) {
				
				System.out.print(arisk);
			}
			
			System.out.println("");
		}
		
		for (int i=1; i<num;i++) {
			
			for(int k=num-1; k>i-1;k--) {
				
				System.out.print(arisk);
			}
			System.out.println("");
		}
		keyboard.close();
	}

}
