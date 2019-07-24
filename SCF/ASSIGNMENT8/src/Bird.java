
 abstract class Bird extends Animal {
	 static String BIRD = "Bird";
	public Bird(String name, int age, float animalWeight) {
		super(name, age, animalWeight);
		
	}
	
	public String getCategory(){
		return "Bird";
	}
	
	public abstract String getSound();
	public abstract String getType();

}
