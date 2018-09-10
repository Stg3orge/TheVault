import java.util.function.*;

public class Container {
	// region Simple container of int
	private int[] a;
	private int n;

	public Container(int size) {// PRE size>=0
		n = 0;
		a = new int[size];
	}

	public int size() {
		return n;
	}

	public int capacity() {
		return a.length;
	}

	public void Add(int e) {// PRE N<Capacity
		a[n] = e;
		n++;
	}

	public int get(int i) {// PRE 0<= i < N
		return a[i];
	}

	public void modifyAll(Function<Integer, Integer> f) {// Applies f to all elements in the container

		for (int i = 0; i < a.length; i++) {
			a[i] = f.apply(a[i]);
		}
	}

	public void modifySome(Function<Integer, Integer> f, Predicate<Integer> p) { // Applies f only to elements in the
																					// container
																					// that satisfies p

		for (int i = 0; i < a.length; i++) {
			if (p.test(a[i])) {
				a[i] = f.apply(a[i]);
			}
		}
	}

	public void displaySome(Consumer<Integer> c, Predicate<Integer> p) {
		for (int i = 0; i < a.length; i++) {
			if (p.test(a[i])) {
				c.accept(a[i]);
			}
		}
	}

	public int sumSome(Predicate<Integer> p) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (p.test(a[i])) {
				sum = sum + a[i];
			}
		}
		return sum;
	}

	public int sumSomeInRange(int startIncl, int endExcl, Predicate<Integer> p) { // Aggregate elements in the container
																					// that satisfy p starting in start
		int sum = 0;
		for (int i = startIncl; i < endExcl; i++) {
			if (p.test(a[i])) {
				sum = sum + a[i];
			}
		}
		return sum;
	}
}
