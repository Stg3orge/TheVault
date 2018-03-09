package spo.opg2;

public abstract class UnaryNode extends Node{
	Node child;	
	protected UnaryNode(Node child) {
		this.child = child;
	}
	public void print_preorder_dfs(){
		print();
		child.print_preorder_dfs();
	}
	
	@Override
	public void print_inorder_dfs() {
		child.print_inorder_dfs();
		print();
	}

	@Override
	public void print_postorder_dfs() {
		child.print_postorder_dfs();
		print();
	}
}
