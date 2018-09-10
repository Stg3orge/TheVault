

public class Pessimist implements Observer {

	@Override
	public void notifyMe(int amount) {
		System.out.println("Pessimist says: Only "+ amount + " cl of cognac left:-(");
	}

}
