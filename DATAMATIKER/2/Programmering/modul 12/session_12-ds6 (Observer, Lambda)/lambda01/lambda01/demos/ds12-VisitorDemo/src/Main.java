import java.util.function.Function;

public class Main {
	private static final int N = 10;
	
	public static void main(String[] args) {
		printContainer("Start values", getContainer());
		modifyAll();
		modifyAllAnonymousInnerClass();
		modifySome();  //* Closures...
		displaySome();
	}
	
	private static Container getContainer() {
		Container con1 = new Container(N);
		for (int i = 0; i < N; i++) {
			con1.add(i);
		}
		return con1;
	}
	
	private static void modifyAll() {
		Container con1 = getContainer();
		con1.modifyAll((x) -> 2*x);
		printContainer("Modify all, lambda", con1);
	}
	
	private static void modifyAllAnonymousInnerClass() {
		Container con1 = getContainer();
		Function<Integer, Integer> doDouble = (x) -> {
			return 2 * x;
		};
		con1.modifyAll(doDouble);
		printContainer("Modify all, anon. inne", con1);
	}
	
	private static void modifySome() {
		Container con1 = getContainer();
		// Closures: variables must be (effectively) final. 
		// c must either be final, or
		// c must never change after being used in the lambda and the compiler has to be able to conclude this
		int c = 2;
		
		Function<Integer, Integer> doubleUp = x -> c * x;
		con1.modifySome(doubleUp, (x) -> x % 2 == 0);
		
		//c = 100; // if you do this, you must copy c into a final local var.
		//final int finalC = c;
		//con1.modifySome((x) -> finalC * x, (x) -> x % 2 == 0);

		printContainer("Modify some", con1);
	}
	
	private static void displaySome() {
		Container con1 = getContainer();
		System.out.println("Disoplay some:");
		con1.displaySome((x) -> {
				System.out.print("Number is: ");
				System.out.println(x);
			}, 
			(x) -> 5 < x && x < 20
		);
	}	
	
	private static void printContainer(String text, Container con1) {
		System.out.println(text + ":");
		System.out.print("[");
		for (int i = 0; i < con1.size(); i++)
			System.out.print(con1.get(i) + (i == con1.size() - 1 ? "" : ", "));
		System.out.println("]");
		System.out.println();
	}

}
