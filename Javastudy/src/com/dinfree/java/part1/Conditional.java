package com.dinfree.java.part1;
import java.util.Scanner;
/*

switch(�Է� ����) {
    case ���ǰ�: ���� ����;break;
    ..
    default: �⺻ ���� ����;
}

�α��� ������ ���� �޴��� ���ƿͼ� �ٽ� �α��� �޴��� �����ϰ� 
�α��� ���а� 3��° �Ǵ� ��� ���α׷��� ���� ����(System.exit(0)) 
������ for ���� ������� ����(���� ���н� ����)

 * */

public class Conditional {
	public int forcnt=0;
	 void login() {
         Scanner scan = new Scanner(System.in);
       
         System.out.print("## ���̵� �Է��ϼ���: ");		
         String uname = scan.next();

         System.out.print("# ��й�ȣ�� �Է��ϼ���: ");
         String pwd = scan.next();

         if(uname.equals("hong") && pwd.equals("1234")) {
         System.out.println("���� Ȯ��!! -> �α��� ����");
         forcnt=0;
         }
         else {
        	 forcnt++;
        	 System.out.println("���̵� ��й�ȣ�� Ʋ�Ƚ��ϴ�.!!");
         }
     }

	 void check() {
     int cnt = 10;
     String msg = cnt > 0? "���ο� ������ �ֽ��ϴ�.!!" : "���ο� ������ �����ϴ�.!!";
     System.out.println(msg);
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conditional con = new Conditional();
	
        while(true) {
            System.out.printf("# �޴��� �����ϼ��� (1:�α���, 2:����Ȯ��, x:����) ==> ");
            Scanner scan = new Scanner(System.in);
            String sel = scan.next();
           
            switch(sel) {
            case "1": con.login();  break;
            case "2": con.check();break;
            case "x": System.exit(0);
            default : System.out.println("�߸��� �Է� �Դϴ�.!!");
            }	
            if(con.forcnt == 3) {
            	System.out.println("\n3���� �α��� ���з� ���� �ý����� ����˴ϴ�");
            	System.exit(0);}
        }
	}

}
