/**
 * Solution to assignment 2 from "before Lecture 1" on 4/2 - 2014
 * 
 * @author Thomas Bøgholm - boegholm@cs.aau.dk
 */


package spo.opg2;

public class Program {
	public static void main(String[] args) {
		Times t = 	new Times(						// Times, root
						new Plus(						// lhs Times
							new Var(						// lhs Plus
								new Value("a")					// Child Var
							),
							new Var(						// rhs Plus
								new Value("n")					// Vhild Var
								)
							),
						new Int(						// rhs Times
							new Value("1")					// child Int
							)
						);
		
		System.out.println("Preorder DFS");
		t.print_preorder_dfs();
		System.out.println();
		System.out.println("Inorder DFS");
		t.print_inorder_dfs();
		System.out.println();
		System.out.println("Postorder DFS");
		t.print_postorder_dfs();
	}
}
