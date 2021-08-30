package DATESERVICE;

public class Characteristic {
	private String description;
	private int rating;
	
	public Characteristic(String s) {
		description =s;
		rating =0;
	}
	private boolean isValid(int aRating) {
		return (aRating<=10&&aRating>=1);
	}
	public void setRating(int aRating) {
		if(this.isValid(aRating)) rating=aRating;
		else System.out.println("Wrong format");
	}
	public String getDescription() {
		return description;
	}
	public int getRating() {
		return rating;
	}
	public double getCompitability(Characteristic otherRating) {
		
		if(isMatch(otherRating)) return this.getCompatibilityMeasure(otherRating);
		else return 0;
	}
	private double getCompatibilityMeasure (Characteristic otherRating) {
		double m=0;
		if(this.rating==0||otherRating.rating==0) {
			System.out.println(" rating value is zero, set the value: ");
		}
		else m= 1-(Math.pow(this.rating-otherRating.rating, 2)/81);
		return m;
	}
	private boolean isMatch(Characteristic otherRating) {
		return this.description.equals(otherRating.description);
	}
}
