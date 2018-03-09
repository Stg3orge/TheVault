import java.util.Scanner;

public class RPNCalculator {
	private static final String BYE = "bye";
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MULTIPLY = "*";
	private static final String MULTIPLY2 = "x";
	private static final String DIVIDE = "/";
	private static final String PLUSMINUS = "+/-";
		
	public static void main(String[] args) {
		new RPNCalculator().start();
	}
	
	private StackIF<Double> stack;
	
	public RPNCalculator() {
		stack = new LinkedStack<>();
	}
	
	/**
	 * Starts a text user interface on the console.
	 */
	private void start() {
		System.out.println("Enter a number, + - * / +/- bye ");
		boolean stop = false;
		Scanner scanner = new Scanner(System.in);
		boolean ok = true; // was the operation successful? Updated in each case in the switch statement.
		while(!stop) {
			System.out.print("> ");
			String input = scanner.nextLine();
			
			switch(input) {
				case BYE:
					stop = true; // stop the console application
					break;
				case PLUS: case MINUS:
				case MULTIPLY: case MULTIPLY2:
				case DIVIDE:
					ok = binaryOperation(input);
					break;
				case PLUSMINUS:
					ok = unaryOperation(input);
					break;
				default:
					ok = number(input); //number(...) returns false if the value couldn't be interpreted as a number
			}
			System.out.print(ok ? "" : "Invalid operation\n"); // Display error on invalid input
			System.out.println(stack.size() > 0 ? stack.peek() : "The stack is empty");	
		}
		System.out.println("Bye...");
		scanner.close();
	}

	/**
	 * Returns the top value of the calculator stack.
	 * This method is not used in the <code>start()</code> but is added to support 
	 * the use of this class as a back end for RPN calculator applications. 
	 * 
	 * @return the Double value of the calculator stack. <code>null</code> is 
	 * returned if the stack is empty.
	 */
	public Double peekStack() {
		Double res = null;
		if(stack.size() > 0) {
			res = stack.peek();			
		}
		return res;
	}

	/**
	 * Call to handle all unary operation cases (+/- -- sign flip) are supported currently. 
	 * This method pushes the resulting value to the stack.
	 * @param input A String representation of one of the supported operations as defined by the
	 * class constants. 
	 * @return <code>true</code> if the parameter could be interpreted as a unary 
	 * operation, there was a number on the stack, and the result was successfully pushed
	 * to the stack. <code>false</code> otherwise.	 
	 */
	public boolean unaryOperation(String input) {
		boolean res = true;
		// check stack size
		if(stack.size() >= 1) {
			// use wrapper class to indicate "unset" (null)
			Double a = null;
			try {
				a = stack.pop();
				double val = 0;
				switch(input) {
					case PLUSMINUS: val = -1d * a; break;
					default: throw new Exception(); // exception if unsupported operation
					// the exception prevents pushing an invalid resulting value onto the stack
				}
				stack.push(val);
			} catch(Exception e) {
				// put back any popped and unused values onto the stack 
				if(a != null) {
					stack.push(a);
					res = false;
				}
			}
		} else {
			res = false;
		}
		return res;
	}
	
	/**
	 * Call to handle all binary operation cases (+, -, *, /) are supported currently. 
	 * This method pushes the resulting value to the stack.
	 * @param input A String representation of one of the supported operations as defined by the
	 * class constants. 
	 * @return <code>true</code> if the parameter could be interpreted as a binary 
	 * operation, there were at least two numbers on the stack, and the result was successfully pushed
	 * to the stack. <code>false</code> otherwise.
	 */
	public boolean binaryOperation(String input) {
		boolean res = true;
		// check that there are at least two numbers on the stack to perform the operation
		// use wrapper class Double to represent "unset" as null.
		if(stack.size() >= 2) {
			// b before a to maintain logical operator order for - (minus) and / (divide)
			Double b = null;
			Double a = null;
			try {
				b = stack.pop();
				a = stack.pop();
				double val = 0; // resulting value
				switch(input) {
					case PLUS: val = a + b; break;
					case MINUS: val = a - b; break;
					case MULTIPLY: case MULTIPLY2:
								val = a * b; break;
					case DIVIDE: val = a / b; break;
					default: throw new Exception(); // break the switch to avoid pushing an invalid value
				}
				stack.push(val);
			} catch (Exception e) {
				res = false;
				// push back any popped and unused values in case the operation couldn't be executed
				// as indicated by the exception thrown above
				// push a before b to preserve the order of the values on the stack
				if(a != null) {
					stack.push(a);
				}
				if(b != null) {
					stack.push(b);
				}
			}
		} else {
			res = false;
		}
		return res;	
	}
	/**
	 * Helper method
	 * @param s A String that is to be converted into a double
	 * @return the double value of parameter <code>a</code>
	 * @throws Exception is thrown if <code>a</code> couldn't be converted to a double 
	 * the reason may be a NPE or NumberFormatException
	 */
	private double getNumericValue(String s) throws Exception {
		try {
			double numVal = Double.parseDouble(s);
			return numVal;
		}catch(NumberFormatException | NullPointerException e) {
			System.out.println("Bad value " + s);
			throw new Exception();
		}
	}
	
	/**
	 * Call this method to handle the input of a number.
	 * @param input
	 * @return <code>true</code> if the parameter could be pushed to the stack as a number. 
	 * <code>false</code> otherwise.
	 */
	public boolean number(String input) {
		boolean res = true;
		try {
			double val = getNumericValue(input);
			stack.push(val);
		}catch(Exception e) {
			res = false;
		}
		return res;
	}
	
}
