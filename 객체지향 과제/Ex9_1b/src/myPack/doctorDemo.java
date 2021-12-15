package myPack;

import myPack.Doctor.spec;

public class doctorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doctor d= new Doctor("Rob", spec.Medicine, 500);
		Doctor d2= new Doctor("Kelly", spec.Oriental, 730);
		
		System.out.println(d);
		System.out.println(d2);
		System.out.println();
		System.out.println(d.equals(d2));
		d.setSpeciality(spec.Oriental);
		System.out.println(d.equals(d2));
		d.setVisit_fee(730);
		System.out.println(d.equals(d2));
		System.out.println();
		System.out.println(d);
		System.out.println(d2);
	}

}
