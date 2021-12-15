package PERSON;

public class persondemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person demo= new Person();
		System.out.println(demo.getName()+" "+demo.getAge());
		System.out.println();
		
		demo= demo.createAdult();
		System.out.println(demo.getName()+" "+demo.getAge());
		demo= demo.createAdolescent();
		System.out.println(demo.getName()+" "+demo.getAge());
		demo= demo.createPreschooler();
		System.out.println(demo.getName()+" "+demo.getAge());
		demo= demo.createTeenager();
		System.out.println(demo.getName()+" "+demo.getAge());
		demo= demo.createToddler();
		System.out.println(demo.getName()+" "+demo.getAge());
		System.out.println();
		
		
		demo.setName("name");
		System.out.println(demo.getName()+" "+demo.getAge());
		demo.setName("Harry", "Potter");
		System.out.println(demo.getName()+" "+demo.getAge());
		
	}

}
