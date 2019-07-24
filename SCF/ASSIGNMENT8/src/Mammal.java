
 abstract class Mammal extends Animal {
	static String MAMMAL = "Mammal";
	public Mammal(String name, int age, float animalWeight) {
		super(name, age, animalWeight);
		
	}
	
	public String getCategory(){
		return "Mammal";
	}
	
	public abstract String getSound();
	public abstract String getType();

}
