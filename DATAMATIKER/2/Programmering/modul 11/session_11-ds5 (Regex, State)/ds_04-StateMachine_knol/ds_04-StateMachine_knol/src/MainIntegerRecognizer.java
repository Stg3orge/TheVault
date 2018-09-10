import mealy.DeterministicMealyMachine;

public class MainIntegerRecognizer {
	public static void main(String[] args) {
		recognizeInteger();
	}

	private static void recognizeInteger() {
		DeterministicMealyMachine<Character> intRecognizer = new DeterministicMealyMachine<>();
		intRecognizer.setStartState("Start");
		intRecognizer.addState("Signed Integer");
		intRecognizer.addAcceptState("Unsigned Int");
		
		intRecognizer.addTransition("Start", "Unsigned Int", c -> c >= '0' && c <= '9', "0..9", () -> System.out.println("Oh, an unsigned int!"));
		intRecognizer.addTransition("Unsigned Int", "Unsigned Int", c -> c >= '0' && c <= '9', "0..9", () -> System.out.println("Oh my, still an unsigned int!"));
		intRecognizer.addTransition("Start", "Signed Integer", c -> c == '+' || c == '-', "+/-", () -> System.out.println("A plus or minus sign!"));
		intRecognizer.addTransition("Signed Integer", "Unsigned Int", c -> c >= '0' && c <= '9', "0..9", () -> System.out.println("I'll have to mingle with the unsigneds!"));
		
		System.out.println("1: " + intRecognizer.accept(toChars("1")));
		System.out.println("12: " + intRecognizer.accept(toChars("12")));
		System.out.println("-1: " + intRecognizer.accept(toChars("-1")));
		System.out.println("+19: " + intRecognizer.accept(toChars("19")));
		System.out.println("a1: " + intRecognizer.accept(toChars("a1")));
		System.out.println("-b: " + intRecognizer.accept(toChars("-b")));
		System.out.println("1b: " + intRecognizer.accept(toChars("1b")));
		System.out.println("<nothing>: " + intRecognizer.accept(toChars("")));
		System.out.println("+: " + intRecognizer.accept(toChars("+")));
		System.out.println("1+: " + intRecognizer.accept(toChars("1+")));
	}

	private static Character[] toChars(String s) {
		char[] c = s.toCharArray();
		Character[] res = new Character[c.length];
		for(int i = 0; i < c.length; i++) {
			res[i] = c[i];
		}
		return res;
	}
}
