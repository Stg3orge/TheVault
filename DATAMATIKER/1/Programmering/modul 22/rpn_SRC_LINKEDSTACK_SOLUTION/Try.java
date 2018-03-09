
public class Try {
	public static void main(String[] args) {
		StackIF<String> stack = new LinkedStack<>();
		stack.push("Joe");
		stack.push("Jane");
		stack.push("Janice");
		
		while(stack.size() > 0) {
			System.out.println(stack.peek());
			System.out.println(stack.pop());
		}
	}
}
