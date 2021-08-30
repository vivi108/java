package BasketballGame;
import java.util.Scanner;
/*
 * attribute 5개, method 5개
 * 농구 경기의 상태를 나타내는 클래스 농구 게임을 생각해 보십시오. 속성은 다음과 같습니다.
- 1군 팀 이름입니다.
-2차팀명 입니다
- 1군 점수입니다.
-2팀 점수입니다.
- 게임 상태(진행 중 또는 진행 중)

Basketball Game은 방법이 있습니다.
- 한 팀에서 1점을 기록합니다.
- 한 팀에서 2점을 획득합니다.
- 한 팀에서 3점을 획득합니다.
-완료된 게임의 상태를 변경합니다.
- 팀 점수를 반환합니다.
- 현재 우승하고 있는 팀의 이름을 반환합니다.

a. 각 방법에 대한 메서드 제목을 작성합니다.
b. 각 방법에 대한 전제 조건 및 사후 조건을 작성합니다.
c. 클래스를 시험하는 자바 statements를 쓰기
d. 클래스를 구현합니다.
e. 구현에 필요한 추가 방법과 속성을 원래 설계에 나열하지 않았습니다. 원래 설계의 다른 변경 사항을 나열합니다.
f. 농구 경기의 점수를 추적하기 위해 농구 게임 클래스를 사용하는 프로그램을 작성합니다. 바구니의 점수가 매겨질 때마다 입력을 읽는 루프를 사용합니다.
(각 바스켓의 채점팀과 채점된 점수(1, 2 또는 3)를 표시해야 합니다.
각 입력을 읽은 후 게임의 현재 점수를 표시합니다.
 */
public class BasketballGame {
	Scanner keyboard = new Scanner(System.in);
	private String name1="Cats", name2= "Dogs";
	public int score1=0, score2=0;
	public int status=0;// 0 for finished, 1 for in progress
	private String winner() {// Return the name of the team that is currently winning.
		if(score1>score2) return name1;
		else if (score1<score2) return name2;
		else return "Both have same score, No one";
	}
	public void result() {
		while (true) {
			System.out.println("\nIs the game finished? if yes then enter 0, else 1");
			status =keyboard.nextInt();
			if (status == 0) break; //Change the status of the game to finished
		
			System.out.println("Enter a score");
			char name = keyboard.next().charAt(0);
			int score = keyboard.nextInt();
			if(name=='a') {
				score1+=score;
				System.out.println(name1+" "+score1+", "+name2+" "+score2+"; "+ this.winner() +" are winning.");
			}
			else if(name =='b') {
				score2+=score;
				System.out.println(name1+" "+score1+", "+name2+" "+score2+"; "+ this.winner() +" are winning.");
			}
			else System.out.println("YOU CAN CHOOSE ONLY a OR b");	
			}
	}
	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	
	
}

