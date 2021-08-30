package myPack;

public class Doctor extends Person{
	enum spec{
		Medicine, Surgery, Dentist, Oriental;
	}
	private spec speciality= spec.Medicine;
	private double visit_fee=0;
	
	
	//four constructors
	public Doctor() {
		super();
	}
	public Doctor(String n) {
		super(n);
	}
	public Doctor(String n, spec e) {
		super(n);
		speciality= e;
	}
	public Doctor(String n, spec e, double fee) {
		super(n);
		speciality= e;
		visit_fee=fee;
	}
	
	//getters and setters
	public spec getSpeciality() {
		return speciality;
	}
	public void setSpeciality(spec speciality) {
		this.speciality = speciality;
	}
	public double getVisit_fee() {
		return visit_fee;
	}
	public void setVisit_fee(double visit_fee) {
		this.visit_fee = visit_fee;
	}
	//toString()
	public String toString() {
		return "Name: "+super.getName()+" speciality: "+ this.getSpeciality()+" visit_fee: "+ this.getVisit_fee();
	}
	//equals(Object)
	public boolean equals(Object other) {
		if(!(other !=null && other instanceof Doctor)) return false;
		Doctor another = (Doctor)other;
		return super.hasSameName(another)&&(this.getSpeciality()==another.getSpeciality())&&(this.getVisit_fee()==another.getVisit_fee());
	}
}
