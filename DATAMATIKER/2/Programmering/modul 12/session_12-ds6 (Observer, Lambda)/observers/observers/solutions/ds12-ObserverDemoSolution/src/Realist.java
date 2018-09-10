/**
 * @author fen
 *
 */
public class Realist implements Observer {

	@Override
	public void notifyMe(int amount) {
		if(amount > 35)
			System.out.println("Realist says: Still "+ amount + " cl of cognac left:-)");
		else
			System.out.println("Realist says: Only "+ amount + " cl of cognac left:-(");
	}
}
