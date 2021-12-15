package Ex9_8;

public class Dog extends Pet{
	private String breed="None";
	private boolean boostershot=false;
	//constructor
	public Dog() {
		super();
	}
	public Dog(String b, boolean shot) {
		super();
		breed= b;
		boostershot = shot;
	}
	//g & s
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public boolean isBoostershot() {
		return boostershot;
	}
	public void setBoostershot(boolean boostershot) {
		this.boostershot = boostershot;
	}
	//equals
	public boolean equals(Object other) {
		if(!(other != null && other instanceof Dog)) return false;
		Dog demo= (Dog)other;
		return this.getName().equals(demo)&&this.getAge()==demo.getAge()&&this.getBreed().equals(demo)&&this.getWeight()==demo.getWeight();
	}
	
	public String toString() {
		return "Name = "+super.getName()+ " Age: "+ super.getAge()+" Weight: "+super.getWeight()+" Breed= "+this.getBreed()+" boostershot? "+this.isBoostershot();
	}
	
}
