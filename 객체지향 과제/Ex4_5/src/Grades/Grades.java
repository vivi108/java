package Grades;
import java.util.Scanner;
/*
 * 지정된 과정의 등급 분포를 나타내는 클래스를 만듭니다. 다음 작업을 수행하는 방법을 쓰십시오.
- 각 문자 등급 A, B, C, D, F의 개수를 설정합니다.
- 각 문자 등급 A, B, C, D, F의 개수를 읽습니다.
- 총 성적수를 반환합니다.
- 각 문자 등급의 백분율을 0에서 100 사이의 정수(포함)로 반환합니다.
-등급 분포의 막대 그래프를 그립니다.

그래프에는 등급당 하나씩 다섯 개의 막대가 표시됩니다. 
각 막대는 행의 별표 수가 각 범주의 등급 백분율에 비례하도록 별표의 수평 행이 될 수 있습니다. 
하나의 별표가 2%를 나타내면 50개의 별표가 100%에 해당합니다. 
수평 축을 0에서 100%까지 10% 단위로 표시하고 각 선에 문자 등급을 표시합니다.

예를 들어 등급이 1A, 4B, 6C, 2D, 1F이면 총 등급 수는 14, 
A의 비율은 7, B의 비율은 29, C의 비율은 43, D의 비율은 14, F의 비율은 7입니다. 
행에는 4개의 별표(가장 가까운 정수로 반올림한 50개 중 7%), 14행, 21행, 7행 및 4행 등이 포함됩니다.
 */
public class Grades {
	private int a=0,b=0,c=0,d=0,f=0, total=0;
	public void bargraph() {
		float aline,bline,cline,dline,fline;
		readthenumber();
		aline= percentage(a);
		bline= percentage(b);
		cline= percentage(c);
		dline= percentage(d);
		fline= percentage(f);
		System.out.println("");
		this.drawline();
		for(int i=0; i<Math.round(aline);i++) {
			System.out.print("*");
		}
		System.out.println(" A");
		for(int i=0; i<Math.round(bline);i++) {
			System.out.print("*");
		}
		System.out.println(" B");
		for(int i=0; i<Math.round(cline);i++) {
			System.out.print("*");
		}
		System.out.println(" C");
		for(int i=0; i<Math.round(dline);i++) {
			System.out.print("*");
		}
		System.out.println(" D");
		for(int i=0; i<Math.round(fline);i++) {
			System.out.print("*");
		}
		System.out.println(" F");
		
	}
	private float percentage(float num) {
		num=(num/total)*50;
		return num;
	}
	private void readthenumber() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the number of the letter grades A");
		a = keyboard.nextInt();
		System.out.println("Enter the number of the letter grades B");
		b = keyboard.nextInt();
		System.out.println("Enter the number of the letter grades C");
		c = keyboard.nextInt();
		System.out.println("Enter the number of the letter grades D");
		d = keyboard.nextInt();
		System.out.println("Enter the number of the letter grades F");
		f = keyboard.nextInt();
		
		total = a+b+c+d+f;
		keyboard.close();
		
	}
	private void drawline() {
		for(int i=0; i<=50;i++) {
			if (i%5==0) System.out.print(i*2+"   ");
		}
		System.out.println("");
		for(int i=0; i<=50;i++) {
			if (i%5==0) System.out.print("|    ");
		}
		System.out.println("");
		for(int i=0; i<50;i++) {
			System.out.print("*");
		}
		System.out.println("");
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
	
}
