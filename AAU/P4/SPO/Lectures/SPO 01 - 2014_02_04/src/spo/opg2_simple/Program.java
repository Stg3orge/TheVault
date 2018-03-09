/**
 * A _simple_ solution to assignment 2 from "before Lecture 1" on 4/2 - 2014
 * 
 * @author Thomas Bøgholm - boegholm@cs.aau.dk
 */

package spo.opg2_simple;

public class Program {
	public static void main(String[] args) {
		Node root = 
			new Node("Times",				// root
				new Node("Plus", 				// left of Times
					new Node("Var", 				// left of Plus
					    new Node("a", null, null),		// left of Var
						null),							// right of Var
					new Node("Var",					// right of Plus
							new Node("n", null, null), 	// left of Var
							null) 						// right of Var
					),
				new Node("Int", 				// right of Times
						new Node("1", null, null),  // left of Int
						null						// right of Int
						)
			);
		
		System.out.println("preorder");
		preorder_DFS(root);
		System.out.println();
		System.out.println("inorder");
		inorder_DFS(root);
		System.out.println();
		System.out.println("postorder");
		postorder_DFS(root);
		System.out.println();
	}
	
	// http://en.wikipedia.org/wiki/Tree_traversal#Depth-first
	public static void preorder_DFS(Node root){
		if(root == null) return;
		System.out.print(root + " ");
		preorder_DFS(root.left);
		preorder_DFS(root.right);
	}
	
	public static void inorder_DFS(Node root){
		if(root == null) return;
		inorder_DFS(root.left);
		System.out.print(root+" ");
		inorder_DFS(root.right);
	}

	public static void postorder_DFS(Node root){
		if(root == null) return;
		postorder_DFS(root.left);
		postorder_DFS(root.right);
		System.out.print(root+" ");
	}

}