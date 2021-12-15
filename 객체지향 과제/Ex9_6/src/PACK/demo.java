package PACK;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person james = new Person("James");
		Person peter = new Person("Peter");
		Truck t= new Truck();
		t.setName("Trolly");
		t.setNumOfcylinders(5000);
		t.setOwner(james);
		t.setLoad(1);
		t.setTow(5);
		
		Truck t2= new Truck(10,15);
		t2.setName("Dump");
		t2.setNumOfcylinders(12000);
		t2.setOwner(peter);
		
		System.out.println();
		System.out.println(t);
		System.out.println(t2);
		System.out.println(t.equals(t2));
	}

}
