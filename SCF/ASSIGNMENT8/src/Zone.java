import java.util.ArrayList;
import java.util.Scanner;

public class Zone {
	int count = 0;
	String zoneName;
	private int zoneID;
	private final int maxCage;
	private boolean hasPark;
	private boolean hasCanteen;
	private ArrayList<Cage> cageList = new ArrayList<Cage>();
	private String category;
	private Scanner sc = new Scanner(System.in);

	public Zone(int zoneCapacity, String name, boolean hasPark,boolean hasCanteen, String category) {
		this.maxCage = zoneCapacity;
		this.zoneName = name;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		this.zoneID = count++;
		this.category = category;
	}

	public boolean AddAnimaltoCage(Animal AnimalToAdded) {
		boolean cagefound = false;
		for (Cage x : getCageList()) {
			if (x.animaltype == AnimalToAdded.getType() && (!x.isFull())) {
				cagefound = true;
				return true;
			}
		}
		if (!cagefound) {
			System.out.println("Cage not found");
			if (addCage(AnimalToAdded.getType())) {
				if (AddAnimaltoCage(AnimalToAdded)) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean addCage(String type) {
		if (maxCage != getCageList().size()) {
			System.out.println("Enter capacity of new cage");
			Scanner sc = new Scanner(System.in);
			int capacity = sc.nextInt();
			Cage c = new Cage(capacity, type);
			getCageList().add(c);
			
			return true;
		}
		System.out.println("zone have reaches maximum no of cage Capacity");
		System.out.println("please Create a new Zone");
		return false;
	}

	public ArrayList<Cage> getCageList() {
		return cageList;
	}

	public int getZooID() {
		return zoneID;
	}

	public boolean hasPark() {
		return hasPark;
	}

	public boolean hasCanteen() {
		return hasCanteen;
	}

	public String getCategory() {
		return category;
	}

	public void display() {
		 System.out.println("details Of Zone :" +zoneID +"  "+zoneName);
	        System.out.println("cageAnimalType  CageCapacity  NoofAnimalInCage" );
	        for(Cage c: cageList)
	            System.out.println( c.getAnimalType() +" "+ c.getCapacity() +" " +c.getNoOfAnimal());
	    }

	} 

