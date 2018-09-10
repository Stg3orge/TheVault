import mealy.DeterministicMealyMachine;

public class MainExamples {
	public static void main(String[] args) {
		noStart();
		noAccept();
		tryAccept();
		tryReadAccept();
	}

	private static DeterministicMealyMachine<String> pupil;
	private static void reset() {
		pupil = new DeterministicMealyMachine<>();
		pupil.addState("Hungry");
		pupil.addState("Sleepy");
		pupil.addState("Playing");
		pupil.addTransition("Hungry", "Sleepy", s -> s.equals("eat"), "eat", () -> System.out.println("I'll sleep methinks"));
		pupil.addTransition("Sleepy", "Playing", s -> s.equals("sleep"), "sleep", () -> System.out.println("Prince of Persia, here I come!"));
		pupil.addTransition("Playing", "Hungry", s -> s.equals("play"), "play", () -> System.out.println("Mmmm... Cold pizza and ketchup!"));
	}
	
	private static void noStart() {
		try {
			reset();
			pupil.addAcceptState("Sleepy");
			pupil.accept("eat");
			pupil.printTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		

	private static void noAccept() {
		try {
			reset();
			pupil.setStartState("Hungry");
			boolean eating = pupil.accept("eat");
			System.out.println();
			boolean sleeping = pupil.accept("eat", "sleep");
			System.out.println();
			boolean playing = pupil.accept("eat", "sleep", "play");
			System.out.println();
			System.out.println("eating: " + eating + ", sleeping: " + sleeping + ", playing: " + playing);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void tryAccept() {
		// TODO Auto-generated method stub
		
	}

	private static void tryReadAccept() {
		// TODO Auto-generated method stub
		
	}
}
