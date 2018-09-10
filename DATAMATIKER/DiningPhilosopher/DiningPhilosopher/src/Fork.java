
public class Fork {
	private int id;
	private boolean isAvailable = true;

	public Fork(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public boolean getAvailablity() {
		return isAvailable;
	}

	/**
	 * 
	 * Synchronized method which makes the thread wait if the fork isn't available
	 * if the fork is available set it to not available
	 */
	public synchronized void pickup(String message, String name) {
		while (!isAvailable) {
			try {
				System.out.println(name + " is waiting for fork nr. " + id);
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isAvailable = false;
		System.out.println(message);
	}

	/**
	 * Synchronized method which sets the fork available and notify all threads that
	 * are waiting
	 */
	public synchronized void putDown(String message) {
		isAvailable = true;
		System.out.println(message);
		notifyAll();
	}
}
