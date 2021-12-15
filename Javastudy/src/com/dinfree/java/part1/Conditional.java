package com.dinfree.java.part1;
import java.util.Scanner;
/*

switch(입력 변수) {
    case 조건값: 실행 구문;break;
    ..
    default: 기본 실행 구문;
}

로그인 실패후 메인 메뉴로 돌아와서 다시 로그인 메뉴를 선택하고 
로그인 실패가 3번째 되는 경우 프로그램을 강제 종료(System.exit(0)) 
별도의 for 문은 사용하지 않음(아직 미학습 상태)

 * */

public class Conditional {
	public int forcnt=0;
	 void login() {
         Scanner scan = new Scanner(System.in);
       
         System.out.print("## 아이디를 입력하세요: ");		
         String uname = scan.next();

         System.out.print("# 비밀번호를 입력하세요: ");
         String pwd = scan.next();

         if(uname.equals("hong") && pwd.equals("1234")) {
         System.out.println("인증 확인!! -> 로그인 성공");
         forcnt=0;
         }
         else {
        	 forcnt++;
        	 System.out.println("아이디나 비밀번호가 틀렸습니다.!!");
         }
     }

	 void check() {
     int cnt = 10;
     String msg = cnt > 0? "새로운 쪽지가 있습니다.!!" : "새로운 쪽지가 없습니다.!!";
     System.out.println(msg);
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conditional con = new Conditional();
	
        while(true) {
            System.out.printf("# 메뉴를 선택하세요 (1:로그인, 2:쪽지확인, x:종료) ==> ");
            Scanner scan = new Scanner(System.in);
            String sel = scan.next();
           
            switch(sel) {
            case "1": con.login();  break;
            case "2": con.check();break;
            case "x": System.exit(0);
            default : System.out.println("잘못된 입력 입니다.!!");
            }	
            if(con.forcnt == 3) {
            	System.out.println("\n3번의 로그인 실패로 인해 시스템이 종료됩니다");
            	System.exit(0);}
        }
	}

}
