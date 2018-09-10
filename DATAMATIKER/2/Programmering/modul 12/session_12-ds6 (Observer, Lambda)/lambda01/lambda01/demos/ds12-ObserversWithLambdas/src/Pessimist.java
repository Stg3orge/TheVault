

public class Pessimist {
	private String name;
	
	public Pessimist(String n) {
		name = n;
	}

	public void notifyMe(int amount) {
		System.out.println("Pessimist " + name + " says: Only "+ amount + " cl of cognac left:-(");
	}
}
