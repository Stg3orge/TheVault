/**
 * A linked implementation of the <code>StackIF</code> interface.
 * @author knol
 * @version 20171024
 * @param <T> The type contained in the stack.
 */
public class LinkedStack<T> implements StackIF<T> {
	/**
	 * Inner class implementing the nodes that are linked together in the stack.
	 * @author knol
	 *
	 * @param <T> Type parameter identical to that of the containing class.
	 */
	private class Node<T>{
		/**
		 * The value stored in each node.
		 */
		private T value;
		
		/**
		 * The node "below" the current node in the stack. <code>null</code> if this is
		 * the bottom node.
		 */
		private LinkedStack<T>.Node<T> next;
		
		/**
		 * Constructor
		 * @param value The value to be contained in this node
		 * @param next The node "below" the current node. <code>null</code> if this is the bottom node.
		 */
		public Node(T value, LinkedStack<T>.Node<T> next) {
			super();
			this.value = value;
			this.next = next;
		}
		
		/**
		 * Returns the value contained in this node.
		 * @return the value of type T contained in this node.
		 */
		public T getValue() {
			return value;
		}
		
		/**
		 * Returns the node "below" of this node in the stack. <code>null</code> if this is the "bottom" node. 
		 * @return The node below this node, <code>null</code> if this is the bottom node.
		 */
		public LinkedStack<T>.Node<T> getNext() {
			return next;
		}
		
	}

	/**
	 * The top node of the stack. <code>null</code> if the stack is empty.
	 */
	private Node<T> top;
	
	/**
	 * The node count of the stack. Must be updated on every modification of the stack size. 
	 * Currently pop() and push(T t) modify this value.
	 */
	private int size;

	/**
	 * Constructor. The top node is set to <code>null</code> and the <code>size</code> is 0.
	 */
	public LinkedStack() {
		top = null;
		size = 0;
	}
	
	@Override
	public void push(T t) {
		Node<T> newNode = new Node<>(t, top);
		top = newNode;
		size++;
	}

	@Override
	public T pop() {
		T res = peek();
		top = top.getNext();
		size--;
		return res;
	}

	@Override
	public T peek() {
		T res = top.getValue();
		return res;
	}

	@Override
	public int size() {
		return size;
	}
}
