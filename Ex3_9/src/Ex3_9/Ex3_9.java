package Ex3_9;
import java.util.Scanner;
/*For all of the following words, 
 * if you move the first letter to the end of the word, 
 * and then spell the result backwards, you will get the original word:
 * banana dresser grammar potato revive uneven assess
 
 */
public class Ex3_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String word, tester, fin;
		char firstletter;
		System.out.println("For all of the following words, if it moved the first letter to the end of the word");
		System.out.println("and then spell the result backwards, it will get the original word");
		System.out.println("Then, it would be going to have 'O' about property");
		System.out.println("");
		while(true) {
			fin="";
			System.out.print("Enter a word, if you want to stop program then enter 'quit': ");
			word=keyboard.next();
			if(word.equals("quit")) {
				System.out.println("end");
				break;
				}
			else {
				word.toLowerCase();
				firstletter=word.charAt(0);
				tester=word.substring(1)+firstletter;
				int cnt=word.length()-1;
				for(int i=cnt; i>=0; i--) {
					fin+=tester.charAt(i);
				}
				System.out.println("(a word read backwards with the first character at the end= "+fin+")");
				if(word.equals(fin)) System.out.println("-----property: O -----");
				else System.out.println("-----property: X -----");
				System.out.println("");
			}	
		}
		keyboard.close();
	}

}
