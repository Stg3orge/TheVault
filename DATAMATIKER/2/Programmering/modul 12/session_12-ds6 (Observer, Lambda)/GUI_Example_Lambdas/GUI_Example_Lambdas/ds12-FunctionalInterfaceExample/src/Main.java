
public class Main {
	public static void main(String[] args) {
		// create a lambda and pass it to the useDoIt method
		System.out.println("example 1");
		String result = new Main().useDoIt((arg1, arg2, arg3) -> (arg1 + arg2) * arg3);
		System.out.println(result);
		
		// reference an existing method and pass it to the useDoIt method
		System.out.println("\nexample 2");
		String result2 = new Main().useDoIt(new Main()::someMethodThatMatchesDoIt);
		System.out.println(result2);
	}
	
	public String useDoIt(DoSomething ds) {
		int x = 2;
		int y = 5;
		int z = 3;
		return "My use of DoSomething is: " + ds.doIt(x, y, z);
	}
	
	public int someMethodThatMatchesDoIt(int joe, int jane, int janice) {
		return joe + jane - janice;
	}
}
