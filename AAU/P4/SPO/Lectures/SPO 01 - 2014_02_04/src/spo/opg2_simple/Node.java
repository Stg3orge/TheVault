/**
 * A very simple general purpose Node class
 * 
 * @author Thomas Bøgholm - boegholm@cs.aau.dk
 */

package spo.opg2_simple;

public class Node {
	@Override
	public String toString() {
		return value;
	}
	
	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public String value;
	public Node left;
	public Node right;
}
