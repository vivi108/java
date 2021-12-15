package Ex9_10;

public class Student extends Person{
	private int studentNumber;
	public Student(){
		super();
		studentNumber = 0;//Indicating no number yet
	 }
	public Student(String initialName, int initialNumber){
		super(initialName);
		studentNumber = initialNumber;
	 }
	public void reset(String newName, int newStudentNumber){
		setName(newName);
		studentNumber = newStudentNumber;
	 }
	public int getStudentNumber(){
		return studentNumber;
	 }
	public void setStudentNumber(int newStudentNumber){
		studentNumber = newStudentNumber;
	 }
	public void writeOutput(){
		System.out.println("Name: " + super.getName());
		System.out.println("Student Number: " + studentNumber);
	 }
	public boolean equals(Student otherStudent){
		return this.hasSameName(otherStudent) && (this.studentNumber == otherStudent.studentNumber);
	 }
}
