package PERSON;

public class Person {
	private String name;
	private int age;
	//public static Person a;
	
	public Person() {
		name= "No name yet";
		age=0;
	}
	public Person(String n, int a) {
		name= n;
		age=a;
	}
	//returns a special instance of this class
	public static Person createAdult() {
		Person a = new Person("An adult", 21);
		return a;
	}
	public static Person createToddler() {
		Person a = new Person("A toddler", 2);
		return a;
	}
	public static Person createPreschooler() {
		Person a = new Person("A preschooler", 5);
		return a;
	}
	public static Person createAdolescent() {
		Person a = new Person("An adolscent", 9);
		return a;
	}
	public static Person createTeenager() {
		Person a = new Person("A teenager", 15);
		return a;
	}
	
	//accessors and mutators below
	public void setName(String first, String last) {
		this.name = first+" "+last;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setNameAge(String n, int a) {
		name= n;
		age=a;
	}
}
