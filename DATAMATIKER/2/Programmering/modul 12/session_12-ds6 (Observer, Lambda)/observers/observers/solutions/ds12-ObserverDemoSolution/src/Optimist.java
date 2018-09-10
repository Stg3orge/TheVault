/**
 * @author fen
 *
 */
public class Optimist implements Observer {

	@Override
	public void notifyMe(int amount) {
		System.out.println("Optimist says: Still "+ amount + " cl of cognac left:-)");
	}

}
