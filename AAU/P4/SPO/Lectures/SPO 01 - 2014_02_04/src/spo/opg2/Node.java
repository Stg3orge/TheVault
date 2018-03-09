/**
 * An abstract Node. Specifies different dfs-based print methods etc.
 * 
 * @author Thomas Bøgholm - boegholm@cs.aau.dk
 */


package spo.opg2;

public abstract class Node {
	public abstract void print_preorder_dfs();
	public abstract void print_inorder_dfs();
	public abstract void print_postorder_dfs();
	
	protected void print(){
		print(this.toString());
	}
	protected void print(String value) {
		System.out.print(value + " ");
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
