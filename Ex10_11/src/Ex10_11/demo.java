package Ex10_11;

import java.util.Arrays;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] s= new Student[] {new Student("Jane", 10), new Student("Rone", 5), new Student("Kelly", 23), new Student("James", 31), new Student("Coco", 50)};
		Arrays.sort(s);
		for(Student i : s ) {
			System.out.println(i);
		}
	}

}
