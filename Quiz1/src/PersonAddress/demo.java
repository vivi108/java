package PersonAddress;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonAddress demo = new PersonAddress();
		PersonAddress otherdemo = new PersonAddress();
		
		demo.setfirstlast("James", "Potter");
		demo.setEmail("james06@gmail.com");
		demo.setPhone("011-7358-5016");
		
		otherdemo.setfirstlast("Emma", "Wattson");
		otherdemo.setEmail("dpaak111@gmail.com");
		otherdemo.setPhone("011-8888-7512");
		
		demo.print();
		otherdemo.print();
		
		if(demo.equals(otherdemo)) System.out.println("EQUALS");
		else System.out.println("NOT EQUALS");

	}

}
