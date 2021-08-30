package Counter;

public class Counter {
	private int count=2;

	public void setNum(int num) {
		if(num<0) System.out.println("ERROR: the integer is negative");
		else count = num;
	}
	public void Reset() {
		count=0;
	}
	public void Increase() {
		count+=1;
	}
	public void Decrease() {
		if (count<=0) System.out.println("ERROR: the integer is negative");
		else count-=1;
	}
	public int getNum() {
		return count;
	}


}
