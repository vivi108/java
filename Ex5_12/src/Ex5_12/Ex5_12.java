package Ex5_12;

public class Ex5_12 {
	private String name="arbi";
	private String MPAA ="G";
	private int terrible=0;
	private int bad=0;
	private int ok=0;
	private int good=0;
	private int great=0;
	public boolean equals(Ex5_12 another) {
		return(this.name.equals(another.name)&&this.MPAA.equals(another.MPAA)&&this.terrible==another.terrible&&this.bad==another.bad&&this.ok==another.ok&&this.good==another.good&&this.great==another.great);
	}
	private int addcount=0;//for counting how many times 'addRating' is called
	public void addRating(int num) {
		if(num==1) {
			this.terrible+=1;
			this.addcount++;
		}
		else if(num==2) {
			this.bad+=1;
			this.addcount++;
		}
		else if(num==3) {
			this.ok+=1;	
			this.addcount++;
		}
		else if(num==4) {
			this.good+=1;
			this.addcount++;
		}
		else if(num==5) {
			this.great+=1;
			this.addcount++;
		}
		else {
			System.out.println("Wrong value");
		}
	}
	public float getAverage() {
		return (float)(this.terrible+this.bad*2+this.ok*3+this.good*4+this.great*5)/this.addcount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMPAA() {
		return MPAA;
	}
	public void setMPAA(String mPAA) {
		MPAA = mPAA;
	}
}
