package Ex5_1;

public class Ex5_1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5_1 demo = new Ex5_1();
		Ex5_1 anotherdemo = new Ex5_1();
		
		anotherdemo.setCurspeed(40);
		if(demo.equals(anotherdemo)) System.out.println("equals");
		else System.out.println("not equals");
		
	}

}
