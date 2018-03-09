/**
 * An interface that implements basic stack functionality. 
 * @author knol
 * @version 20171024
 * @param <T> The type the stack shall contain
 */
public interface StackIF<T> {
	/**
	 * Push a value of type T onto the top of the stack.
	 * @param t a value pushed onto the stack
	 */
	void push(T t);
	
	/**
	 * Return and remove (pop) the top value from the stack. 
	 * <code>pop()</code> is equivalent to <code>peek()</code> and 
	 * a simultaneous removal of the top value from the stack.
	 * @return the value of type T from the top of the stack.
	 */
	T pop();
	
	/**
	 * Return and retain (peek) the top value from the stack. 
	 * @return the value of type T from the top of the stack.
	 */
	T peek();
	
	/**
	 * Returns the number of elements pushed onto the stack.
	 * @return The number of elements contained in the stack.
	 */
	int size();
}
