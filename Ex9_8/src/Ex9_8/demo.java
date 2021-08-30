package Ex9_8;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog[] d= new Dog[5] ;
		for(int i=0; i<5; i++) {
			d[i]= new Dog();
		}
		
		
		d[0].setBreed("maltese");
		d[0].setBoostershot(false);
		d[0].setName("Kitty");
		d[0].setAge(1);
		d[0].setWeight(.5);
		
		d[1].setBreed("pomeranian");
		d[1].setBoostershot(true);
		d[1].setPet("Jasmin", 2, 1.3);
		
		d[2].setBreed("poodle");
		d[2].setBoostershot(true);
		d[2].setPet("Aran", 4, 2.2);
		
		d[3].setBreed("husky");
		d[3].setBoostershot(true);
		d[3].setPet("Ronny", 4, 2.5);
		
		d[4].setBreed("beagle");
		d[4].setBoostershot(true);
		d[4].setPet("Apple", 7, 2.6);
		
		for(int i=0; i<5; i++) {
			System.out.println(d[i]);
		}
		
		System.out.println();
		System.out.println(d[2].equals(d[4]));
		System.out.println(d[0].equals(d[1]));
		System.out.println();
		
		//over 2 old, not booster shot
		System.out.println("over 2 old, not booster shot= ");
		for(int i=0; i<5; i++) {
			if(d[i].getAge()>=2 && !(d[i].isBoostershot())) System.out.println(d[i].getName());
		}
		
		d[4].setBoostershot(false);
		d[3].setBoostershot(false);
		for(int i=0; i<5; i++) {
			if(d[i].getAge()>=2 && !(d[i].isBoostershot())) System.out.println(d[i].getName());
		}
	}

}
