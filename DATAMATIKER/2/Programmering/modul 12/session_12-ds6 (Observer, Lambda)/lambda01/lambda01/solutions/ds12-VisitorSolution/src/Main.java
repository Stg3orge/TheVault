import java.util.function.Function;

public class Main {

	public static void main(String[] args) {

		int n = 10;
		Container con1 = new Container(n);
		for (int i = 0; i < n; i++) {
			con1.Add(i);
		}

		printContainer("Printing start values", con1);

		// con1.modifyAll((x) -> 2*x);

		Function<Integer, Integer> doDouble = (x) -> {
			return 2 * x;
		};
		con1.modifyAll(doDouble);

		printContainer("Doubling all", con1);

		// int c = 2;
		// con1.modifySome((x) -> c * x,
		// (x) -> x % 2 == 0);

		con1.modifySome((x) -> 2 * x, (x) -> x % 2 == 0);

		printContainer("Doubling evens", con1);

		con1.displaySome((x) -> {
			System.out.print("Number is: ");
			System.out.println(x);
		}, (x) -> 5 < x && x < 20);

		con1.modifySome((x) -> x + 7, (x) -> x >= 20);

		printContainer("Increasing big ones by 7: ", con1);

		System.out.println("Summing big ones: " + con1.sumSome((x) -> x >= 20));

		System.out.println("Summing some of the big ones: " + con1.sumSomeInRange(3, 6, (x) -> x >= 20));

	}

	private static void printContainer(String text, Container con1) {
		System.out.println(text + ":");
		System.out.print("[");
		for (int i = 0; i < con1.size(); i++) {
			System.out.print(con1.get(i) + ", ");
		}
		System.out.println("]");
		System.out.println();
	}

}
