/**
 * @author fen
 *
 */
public class Optimist {
	private String name;
	
	public Optimist(String n) {
		name = n;
	}
	public void notifyMe(int amount) {
		System.out.println("Optimist " + name + " says: Still "+ amount + " cl of cognac left:-)");
	}

}
