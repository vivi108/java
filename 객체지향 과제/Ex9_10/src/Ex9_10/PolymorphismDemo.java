package Ex9_10;

public class PolymorphismDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] people = new Person[6];
		 people[0] = new Undergraduate("Cotty, Manny", 4910, 1);
		 people[1] = new Undergraduate("Kick, Anita", 9931, 2);
		 people[2] = new Student("DeBanque, Robin", 8812);
		 people[3] = new Undergraduate("Bugg, June", 9901, 4);
		 people[4] = new Faculty("Professor of computer science",1234,"IT","James, Potter" );
		 people[5] = new Staff(10, 6678, "AI", "Rob, K");
		for (Person p : people) {
		 p.writeOutput();
		 System.out.println();
		}
	}
}
