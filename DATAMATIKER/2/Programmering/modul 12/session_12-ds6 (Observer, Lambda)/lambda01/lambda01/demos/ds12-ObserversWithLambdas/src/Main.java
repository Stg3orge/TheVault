/**
 * @author fen 2015-03-20
 *
 */
public class Main {
	private static void staticMethod(int arg) {
		System.out.println("Static: the bottle has: " + arg + " cl booze");
	}
	public static void main(String[] args) {
		Bottle myBottle = new Bottle();
		Optimist o1 = new Optimist("Joe");
		Optimist o2 = new Optimist("Jane");
		Pessimist p1 = new Pessimist("Goofy");
		Pessimist p2 = new Pessimist("Lolcat");
		myBottle.addObserver(o1::notifyMe); // <-- object::methodName
		myBottle.addObserver(o2::notifyMe);
		myBottle.addObserver(p1::notifyMe);
		myBottle.addObserver(p2::notifyMe);
		
		// you may use static methods as well
		myBottle.addObserver(Main::staticMethod); // <-- Class::staticMethodName

		// One doesn't need a class: The callback method may be added directly as a lambda:
		myBottle.addObserver((amount) -> {
			System.out.print("/lambda/ ");
			if (amount > 35) {
				System.out.println("Realist says: Still " + amount + " cl of cognac left:-)");
			} else {
				System.out.println("Realist says: Only " + amount + " cl of cognac left:-(");
			}
		});
		
		// another lambda like above:
		myBottle.addObserver(volume -> System.out.println("/lambda 2/ I see " + volume + " cl"));
		
		
		System.out.println("Drinking:");
		myBottle.changeAmount(33);

		// System.out.println("Filling the bottle:");
		// myBottle.fillBottle();
	}
}
