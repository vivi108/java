package TICTACTOE;
import java.util.Scanner;

public class TicTacToe {
	Scanner keyboard= new Scanner(System.in);
	public char[][] game =new char[3][3];
	
	
	private int who_s_turn(int turn) {
		if(turn%2==0) {
			System.out.println("O's turn: Enter the row value, column value ");
			return 1;
		}
		else {
			System.out.println("X's turn: Enter the row value, column value");
			return -1;
		}
		
	}
	
	public void gameset() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				game[i][j]='\0';
			}
		}
	}
	
	public void gaming() {
		int row, column;
		
		gameset();
		printboard();
		for(int i=0; i<9 ; i++) {
			
			
			if(who_s_turn(i) ==1) {
				row=keyboard.nextInt();
				column =keyboard.nextInt();
				addmove(row, column, 'O');
			}
			else {
				row=keyboard.nextInt();
				column =keyboard.nextInt();
				addmove(row, column, 'X');
				
			}
			printboard();
			if(is_winner()!= -1) {
				who_is_winner();
				break;
			}
			
		}
	}
	private void addmove(int row, int column, char value) {
			
		if(game[row][column]=='\0') {
			game[row][column]=value;
		}
		
	}
	public void printboard() {
		System.out.println("---------------\n  0  1  2");
		for(int i=0; i<3; i++) {
			System.out.print(i);
			for(int j=0; j<3; j++) {
				System.out.print("| "+game[i][j]);
			}
			System.out.println("");
		}
		System.out.println("---------------");
	}
	private int is_winner() {
			if(game[0][0]!='\0'&&game[0][0]==game[0][1]&&game[0][1]==game[0][2]) return 0;
			else if(game[1][0]!='\0'&&game[1][0]==game[1][1]&&game[1][1]==game[1][2]) return 1;
			else if(game[2][0]!='\0'&&game[2][0]==game[2][1]&&game[2][1]==game[2][2]) return 2;
			else if(game[0][0]!='\0'&&game[0][0]==game[1][0]&&game[1][0]==game[2][0]) return 3;
			else if(game[1][1]!='\0'&&game[0][1]==game[1][1]&&game[1][1]==game[2][1]) return 4;
			else if(game[1][2]!='\0'&&game[0][2]==game[1][2]&&game[1][2]==game[2][2]) return 5;
			else if(game[1][1]!='\0'&&game[0][0]==game[1][1]&&game[1][1]==game[2][2]) return 6;
			else if(game[1][1]!='\0'&&game[0][2]==game[1][1]&&game[1][1]==game[2][0]) return 7;
			else {
				return -1;
			}
		
	}
	private void who_is_winner() {
		int a= is_winner();
		char win='\0';
		
		if(a==1)  win =game[0][0];
		else if(a==2) win =game[1][0];
		else if(a==3) win =game[2][0];
		else if(a==4) win =game[1][1];
		else if(a==5) win =game[1][2];
		else if(a==6) win =game[1][1];
		else if(a==7) win =game[1][1];
		
		if(win!= '\0') System.out.println("the winner is = "+win);
		else System.out.println("there is no winner");
		
	}
	
	
	
	
	
	
}
