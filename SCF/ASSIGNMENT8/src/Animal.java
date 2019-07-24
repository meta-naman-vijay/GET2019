
public  abstract class Animal {
	static int count=0;
	static String AnimalName;
	static float AnimalWeight;
	static int AnimalAge;
	static int AnimalId;
	public Animal(String name,int age,float animalWeight2){
		count++;
		this.AnimalId = count;
		this.AnimalName = name;
		this.AnimalWeight = animalWeight2;
		this.AnimalAge = age;
	}
	
	

	public int getAnimalId(){
		return AnimalId;
	}
	
	public float getAnimalWeight(){
		return AnimalWeight;
	}
	
	public int getAnimalAge(){
		return AnimalAge;
	}
	
	public String getAnimalName(){
		return AnimalName;
	}

	abstract public String getCategory();
	abstract public String getSound();
	abstract public String getType();
}
