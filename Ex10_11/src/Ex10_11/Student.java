package Ex10_11;

public class Student implements java.lang.Comparable{
	private int studentNumber;
	private String name="no name yet";
	public Student(){
		studentNumber = 0;//Indicating no number yet
	 }
	public Student(String initialName, int initialNumber) {
		name= initialName;
		studentNumber = initialNumber;
	 }
	public void reset(String newName, int newStudentNumber) {
		setName(newName);
		studentNumber = newStudentNumber;
	 }
	public int getStudentNumber() {
		return studentNumber;
	 }
	public void setStudentNumber(int newStudentNumber){
		studentNumber = newStudentNumber;
	 }
	public void writeOutput(){
		System.out.println("Name: " + getName());
		System.out.println("Student Number: " + studentNumber);
	 }
	public boolean equals(Student otherStudent){
	return this.name.equalsIgnoreCase(otherStudent.name) && (this.studentNumber == otherStudent.studentNumber);
	 }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name+" "+ studentNumber;
	}
	//compareto
	public int compareTo(Object ob) {
		if(!(ob!=null&&ob instanceof Student)) return 0;
		Student s= (Student)ob;
		return this.name.compareTo(s.name);
		//return this.studentNumber-s.studentNumber;
	}
}
