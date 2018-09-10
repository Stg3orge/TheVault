import java.util.Random;

public class Philosopher extends Thread {
	private String name;
	private Fork main;
	private Fork secondary;
	private String pickedUpMain = " has picked up his main fork! Which is ";
	private String pickedUpSecondary = " has picked up his secondary fork! Which is ";

	public Philosopher(String name, Fork main, Fork secondary) {
		this.name = name;
		this.main = main;
		this.secondary = secondary;
	}

	/**
	 * The thread's run method.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				thinking();

				eat();

				System.out.println(this.name + " is full!");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(this.name + "had a problem");

		}

	}

	/**
	 * The philosopher eat method. It picks up a main and secondary fork, eats (wait
	 * for a random amount time under 3 sec), and put down the forks again.
	 * 
	 * @throws InterruptedException
	 */
	private void eat() throws InterruptedException {

		// Checks what fork is the lowest and picks up the lowest first
		if (main.getId() < secondary.getId()) {
			main.pickup(this.name + pickedUpMain + main.getId(), this.name);
			secondary.pickup(this.name + pickedUpSecondary + secondary.getId(), this.name);
		} else {
			secondary.pickup(this.name + pickedUpSecondary + secondary.getId(), this.name);
			main.pickup(this.name + pickedUpMain + main.getId(), this.name);

		}

		// Eating
		System.out.println(this.name + " is eating! NOM NOM!!!");
		Philosopher.sleep(new Random().nextInt(3000));

		// Put down main
		main.putDown(this.name + " has putdown his main fork! Which is " + main.getId());

		// Put down secondary
		secondary.putDown(this.name + " has putdown his secondary fork! Which is " + secondary.getId());

	}

	/**
	 * Waits some time
	 */
	private void thinking() throws InterruptedException {
		System.out.println(this.name + " is thinking......");
		Philosopher.sleep(new Random().nextInt(3000));
	}
}
