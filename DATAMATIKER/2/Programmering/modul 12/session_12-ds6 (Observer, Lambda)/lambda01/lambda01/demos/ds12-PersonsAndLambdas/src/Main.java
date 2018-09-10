import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {

	public static void main(String[] args) {
		Collection<Person>  myCol = new LinkedList<>();
		createTestData(myCol);
		printCol(myCol);
		System.out.println();
		
		Collections.sort((List<Person>)myCol);
		System.out.println("All sorted: ");
		printCol(myCol);

		System.out.println();
		System.out.println("Printing using lambda:");		
		myCol.stream()
				.forEach((p) -> System.out.println(p));
		
		System.out.println();
		System.out.println("Older than 40: ");
		myCol.stream()
			.filter(e -> e.getAge() > 40)
				.forEach(e -> System.out.println(e));
		
		System.out.println();
		int totalAge = myCol
				.stream()
				.map(Person::getAge)
//				.map((p) -> p.getAge())
				.reduce(0, (x,y) -> x+y);
		System.out.println("Average age: " + (double)totalAge/myCol.size());
	}

	private static void printCol(Collection<Person> myCol) {
		for(Person p : myCol) {
			System.out.println(p.getName() + ": " + p.getAge());
		}
	}

	private static void createTestData(Collection<Person> myCol) {
		Random rnd = new Random(1000l);
		myCol.add(new Person("Ib", guessAnAge(rnd)));
		myCol.add(new Person("Finn", guessAnAge(rnd)));
		myCol.add(new Person("Mogens", guessAnAge(rnd)));
		myCol.add(new Person("Poul", guessAnAge(rnd)));
		myCol.add(new Person("Torben", guessAnAge(rnd)));
		myCol.add(new Person("Anita", guessAnAge(rnd)));
		myCol.add(new Person("Istvan", guessAnAge(rnd)));
		myCol.add(new Person("Henrik", guessAnAge(rnd)));
		myCol.add(new Person("Nadeem", guessAnAge(rnd)));
		myCol.add(new Person("Gianna", guessAnAge(rnd)));
		myCol.add(new Person("Per", guessAnAge(rnd)));
		myCol.add(new Person("Simon", guessAnAge(rnd)));
		myCol.add(new Person("Rasmus", guessAnAge(rnd)));
		myCol.add(new Person("Ronni", guessAnAge(rnd)));
		myCol.add(new Person("Lars", guessAnAge(rnd)));
		myCol.add(new Person("Jørgen", guessAnAge(rnd)));
		
	}
	
	private static int guessAnAge(Random rnd) {
		return rnd.nextInt(40) + 20;
	}

}
