
 abstract class Reptile extends Animal {
	 static String REPTILE = "Reptile";
	public Reptile(String name, int age, float animalWeight) {
		super(name, age, animalWeight);
		
	}
	
	public String getCategory(){
		return "Reptile";
	}
	
	public abstract String getSound();
	public abstract String getType();

}
