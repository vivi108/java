package quiz2;

import java.util.Arrays;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Truck[] s= new Truck[] {new Truck(15,20,"A", 10), new Truck(15,20,"A", 5), new Truck(20,30,"A", 23), new Truck(30,40,"B", 31), new Truck(40,50,"B", 50)};
		Person[] p=new Person[] {new Person("Jane"),new Person("Rone"),new Person("Coco"),new Person("Kelly"),new Person("James")};
		double[] l = {10,11,10,11,10};
		for(int i=0; i<5; i++) {
			s[i].setOwner(p[i]);
			s[i].setCurrentLoad(l[i]);
		}
		
		System.out.println(s[0].equals(s[0]));
		System.out.println(s[0].equals(s[1]));
		System.out.println(s[0].equals(s[2]));
		System.out.println(s[0].equals(s[3]));
		System.out.println(s[0].equals(s[4]));
		
		Arrays.sort(s);
		for(Truck i : s ) {
			System.out.println(i);
		}
	}

}
