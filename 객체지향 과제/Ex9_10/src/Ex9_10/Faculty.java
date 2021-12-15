package Ex9_10;

public class Faculty extends Employee {
	private String title="NONE";
	//constructor
	public Faculty() {
		super();
	}
	public Faculty(String t) {
		super();
		title=t;
	}
	public Faculty(String t, int i, String d, String n) {
		super(i, d, n);
		title=t;
	}
	//getter & setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	//write
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Title: " + title);
	}
}
