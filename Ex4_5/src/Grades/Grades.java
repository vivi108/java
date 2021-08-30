package Grades;
import java.util.Scanner;
/*
 * ������ ������ ��� ������ ��Ÿ���� Ŭ������ ����ϴ�. ���� �۾��� �����ϴ� ����� ���ʽÿ�.
- �� ���� ��� A, B, C, D, F�� ������ �����մϴ�.
- �� ���� ��� A, B, C, D, F�� ������ �н��ϴ�.
- �� �������� ��ȯ�մϴ�.
- �� ���� ����� ������� 0���� 100 ������ ����(����)�� ��ȯ�մϴ�.
-��� ������ ���� �׷����� �׸��ϴ�.

�׷������� ��޴� �ϳ��� �ټ� ���� ���밡 ǥ�õ˴ϴ�. 
�� ����� ���� ��ǥ ���� �� ������ ��� ������� ����ϵ��� ��ǥ�� ���� ���� �� �� �ֽ��ϴ�. 
�ϳ��� ��ǥ�� 2%�� ��Ÿ���� 50���� ��ǥ�� 100%�� �ش��մϴ�. 
���� ���� 0���� 100%���� 10% ������ ǥ���ϰ� �� ���� ���� ����� ǥ���մϴ�.

���� ��� ����� 1A, 4B, 6C, 2D, 1F�̸� �� ��� ���� 14, 
A�� ������ 7, B�� ������ 29, C�� ������ 43, D�� ������ 14, F�� ������ 7�Դϴ�. 
�࿡�� 4���� ��ǥ(���� ����� ������ �ݿø��� 50�� �� 7%), 14��, 21��, 7�� �� 4�� ���� ���Ե˴ϴ�.
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
