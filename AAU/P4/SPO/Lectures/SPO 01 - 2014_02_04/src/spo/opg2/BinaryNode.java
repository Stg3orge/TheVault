/**
 * An abstract Node with two children
 * 
 * @author Thomas Bøgholm - boegholm@cs.aau.dk
 */

package spo.opg2;

public abstract class BinaryNode extends Node{
	Node leftOperand, rightOperand;
	protected BinaryNode(Node leftOperand, Node rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	@Override
	public void print_preorder_dfs() {
		print();
		leftOperand.print_preorder_dfs();
		rightOperand.print_preorder_dfs();
	}
	
	@Override
	public void print_inorder_dfs() {
		leftOperand.print_inorder_dfs();
		print();
		rightOperand.print_inorder_dfs();
	}
	
	@Override
	public void print_postorder_dfs() {
		leftOperand.print_postorder_dfs();
		rightOperand.print_postorder_dfs();
		print();
	}
}
