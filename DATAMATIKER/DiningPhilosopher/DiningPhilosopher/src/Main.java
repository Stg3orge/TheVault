/**
 * 
 * @author Gruppe 2 : Andreas Larsen, Jacob Thomsen, Katrine Madsen og Matias
 *         Kragh
 * 
 *         We have implemented a solution to the Philosopher problem where we
 *         have removed circular wait by giving the Forks an id and always
 *         picking the lowest id that the philosopher have access to
 *         (constructor arguments).
 *
 */

public class Main {

	public static void main(String[] args) {
		Fork f1 = new Fork(1);
		Fork f2 = new Fork(2);
		Fork f3 = new Fork(3);
		Fork f4 = new Fork(4);
		Fork f5 = new Fork(5);

		Philosopher p1 = new Philosopher("Crantor", f1, f2);
		Philosopher p2 = new Philosopher("Euenus", f2, f3);
		Philosopher p3 = new Philosopher("Gorgias", f3, f4);
		Philosopher p4 = new Philosopher("Hegias", f4, f5);
		Philosopher p5 = new Philosopher("Leontion", f5, f1);

		System.out.println("PASTA IS SERVED!");
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}

}
