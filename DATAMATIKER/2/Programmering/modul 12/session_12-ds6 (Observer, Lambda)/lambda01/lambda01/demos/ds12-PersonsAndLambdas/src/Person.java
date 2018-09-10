
public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person arg0) {
		return this.getName().compareTo(arg0.getName());
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Person)) {
			return false;
		}
		return this.compareTo((Person)o) == 0;
	}

	@Override
	public String toString() {
		return name + ": " + age ;
	}
	
	
}
