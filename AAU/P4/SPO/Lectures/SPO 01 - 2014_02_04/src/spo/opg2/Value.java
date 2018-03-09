package spo.opg2;

public class Value extends Node{
	private String value;
	public Value(String value) {
		this.value = value;
	}
	@Override
	public void print_preorder_dfs() {
		print();
	}
	@Override
	public void print_inorder_dfs() {
		print();
	}
	@Override
	public void print_postorder_dfs() {
		print();
	}
	@Override
	protected void print() {
		print(value);
	}
}
