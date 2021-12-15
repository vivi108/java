package com.dinfree.java.part1;

public class ScoreManager {
//202035400 현도연
	
	public String[] name= {};
	public int[] java={};
	public int[] ai={};
	public int[] math={};
	public int[] sum={};
	public int[] average={};
	
	public void genData() {
		
		this.name[0] ="현도연";
		this.name[1]= "홍길동";
		this.name[2]= "아무개";
		this.java[0]= 90;
		this.java[1]= 88;
		this.java[2]= 95;
		this.ai[0]= 88;
		this.ai[1]= 85;
		this.ai[2]= 91;
		this.math[0]= 91;
		this.math[1]= 86;
		this.math[2]= 92;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				this.sum[i]+=java[j]+ai[j]+math[j];
			}this.average[i]= sum[i]/3;
		}

	}
	public void printData() {
		System.out.println("## 학생별 성적 현황 ##");
		System.out.println("이름\t자바\t인공지능\t이산수학\t총점\t평균");
		for(int i=0; i<3; i++) {
			System.out.println(name[i]+"\t"+java[i]+"\t"+ai[i]+"\t"+math[i]+"\t"+sum[i]+"\t"+average[i]);
		}
	}
	public static void main(String[] args) {
		ScoreManager a= new ScoreManager();
		a.genData();
		a.printData();

	}

}
