package BasketballGame;
import java.util.Scanner;
/*
 * attribute 5��, method 5��
 * �� ����� ���¸� ��Ÿ���� Ŭ���� �� ������ ������ ���ʽÿ�. �Ӽ��� ������ �����ϴ�.
- 1�� �� �̸��Դϴ�.
-2������ �Դϴ�
- 1�� �����Դϴ�.
-2�� �����Դϴ�.
- ���� ����(���� �� �Ǵ� ���� ��)

Basketball Game�� ����� �ֽ��ϴ�.
- �� ������ 1���� ����մϴ�.
- �� ������ 2���� ȹ���մϴ�.
- �� ������ 3���� ȹ���մϴ�.
-�Ϸ�� ������ ���¸� �����մϴ�.
- �� ������ ��ȯ�մϴ�.
- ���� ����ϰ� �ִ� ���� �̸��� ��ȯ�մϴ�.

a. �� ����� ���� �޼��� ������ �ۼ��մϴ�.
b. �� ����� ���� ���� ���� �� ���� ������ �ۼ��մϴ�.
c. Ŭ������ �����ϴ� �ڹ� statements�� ����
d. Ŭ������ �����մϴ�.
e. ������ �ʿ��� �߰� ����� �Ӽ��� ���� ���迡 �������� �ʾҽ��ϴ�. ���� ������ �ٸ� ���� ������ �����մϴ�.
f. �� ����� ������ �����ϱ� ���� �� ���� Ŭ������ ����ϴ� ���α׷��� �ۼ��մϴ�. �ٱ����� ������ �Ű��� ������ �Է��� �д� ������ ����մϴ�.
(�� �ٽ����� ä������ ä���� ����(1, 2 �Ǵ� 3)�� ǥ���ؾ� �մϴ�.
�� �Է��� ���� �� ������ ���� ������ ǥ���մϴ�.
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

