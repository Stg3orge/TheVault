package mealy;

public class Switch {
	public static void main(String[] args) {
		onOff();
	}
	
	private static void onOff() {
		DeterministicMealyMachine<Character> onOff = new DeterministicMealyMachine<>();
		onOff.setStartState("off");
		onOff.addAcceptState("off");
		onOff.addState("on");
		onOff.addTransition("off", "on", c -> c == '+', "c == '+'", () -> System.out.println("*"));
		onOff.addTransition("on", "off", c -> c == '-', "c == '-'", ()->System.out.println("o"));
		
		onOff.read('+');
		onOff.read('-');
		onOff.read('+');
		boolean res = onOff.read('-');
		//onOff.read('-');

		System.out.println("res = " + res);
		onOff.printTrace();
		
		System.out.println("Wrong sequence");
		boolean accept = onOff.accept('+', '-', '+', '+');
		System.out.println("accept:" + accept);
		
		System.out.println("Wrong end state");
		accept = onOff.accept('+', '-', '+', '+');
		System.out.println("accept:" + accept);

		
		System.out.println("Should be happy");
		accept = onOff.accept('+', '-', '+', '-');
		System.out.println("accept:" + accept);
	}

}
