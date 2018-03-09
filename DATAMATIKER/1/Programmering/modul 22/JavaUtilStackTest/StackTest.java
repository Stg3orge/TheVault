
/**
 * Tries out some features of java.util.Stack
 * 
 * @author (fen) 
 * @version (2016-10-26)
 */

import java.util.Stack;

public class StackTest {
    private Stack<String> stringStack;
    private Stack<Integer> intStack;

    public void testString() {
        stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        System.out.println("peek: " + stringStack.peek());
        System.out.println("pop: " + stringStack.pop());
        System.out.println("peek: " + stringStack.peek());
    }

    public void testInteger() {
        intStack = new Stack<>();
        System.out.println("Pushing: ");
        for (int i = 10; i < 20; i++) {
            System.out.print(i + "\t");
            intStack.push(i);
        }
        System.out.println();

        System.out.println("Poppping: ");
        while (!intStack.isEmpty()) {
            System.out.print(intStack.pop() + "\t");
        }
        System.out.println();
    }

    // simple version: knol
    public void parBal1(String s) {
        stringStack = new Stack<>();
        char[] tokens = s.toCharArray();
        boolean ok = true;
        for(int i=0; ok && i < tokens.length; i++) {
            if(tokens[i] == '{') {      // alwas push opening brackets
                stringStack.push("{");
            }
            else if(tokens[i] == '}') { 
                // pop closing brackets if there was an opening bracket
                if (!stringStack.isEmpty() && stringStack.peek().equals("}")) {
                    stringStack.pop();
                }
                else { // fail if there was a closing bracket without an opening one
                    ok = false;
                }
            }
        }
        ok = ok && stringStack.isEmpty(); // by the end there must be no unclosed opening brackets
        // we detected an overflow of closing brackets while analyzing the string
        // we detect an overflow of opening brackets in the above line of code
        System.out.println("Your input was " + (ok ? "OK" : "bad"));
    }
    
    // more general version: fen
    public void parBal(String s) {
        stringStack = new Stack<>();
        boolean ok = true;
        int i = 0;
        while (ok && i < s.length()) {
            String tmp = s.substring(i, i + 1);
            if (startSym(tmp)) {
                stringStack.push(tmp);
            }
            if (endSym(tmp)) {
                if (!stringStack.isEmpty()) {
                    String stTop = stringStack.pop();
                    if (!match(stTop, tmp))
                        ok = false;
                } else {
                    System.out.println("Too many end parentheses");
                    ok = false;
                }
            }
            i++;
        }
        if (!stringStack.isEmpty()) {
            System.out.println("Too many end parentheses");
            ok = false;
        }
        if (ok)
            System.out.println("Parentheses are ok");
    }

    private boolean startSym(String s) {
        boolean ok = false;
        if (s.equals("{"))
            ok = true;
        // if(s.equals("["))
        // ok= true;
        // if(s.equals("("))
        // ok= true;
        return ok;
    }

    private boolean endSym(String s) {
        boolean ok = false;
        if (s.equals("}"))
            ok = true;
        // if(s.equals("]"))
        // ok= true;
        // if(s.equals(")"))
        // ok= true;
        return ok;
    }

    private boolean match(String start, String end) {
    boolean ok = false;
        if (start.equals("{"))
            ok = end.equals("}");
        // if(start.equals("["))
        // ok= end.equals("]");
        // if(start.equals("("))
        // ok= end.equals(")");
        return ok;
    }

}
