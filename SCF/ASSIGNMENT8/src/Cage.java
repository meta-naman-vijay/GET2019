import java.util.ArrayList;

public class Cage {
	public int count = 0;
	int Cagecapacity;
	public String animaltype;
	int cageId;
	int NoOfanimal;
	private ArrayList<Animal> animalList = new ArrayList<Animal>();

	public Cage(int capacity, String name) {
		count++;
		this.Cagecapacity = capacity;
		this.animaltype = name;
		this.cageId = count;
		this.NoOfanimal=0;
	}

	public Boolean isFull() {
		if (Cagecapacity == NoOfanimal)
			return true;
		return false;
	}

	public boolean addanimal(Animal tobeAdded) {
		if (Cagecapacity != NoOfanimal && animaltype == tobeAdded.getType()) {
			getAnimalList().add(tobeAdded);
			NoOfanimal++;
			return true;
		}
		return false;
	}

	public ArrayList<Animal> getAnimalList() {
		return animalList;
	}

	public String getAnimalType() {
		return animaltype;
	}

	public int getCapacity() {
		return Cagecapacity;
	}

	public int getNoOfAnimal() {
		return NoOfanimal;
	}

}
