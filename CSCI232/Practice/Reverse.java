/******************************************************************************
 *  Compilation:  javac Reverse.java
 *  Execution:    java Reverse
 *  Dependencies: Stack.java StdOut.java StdIn.java
 *
 *  Read a sequence of integers from standard input and print them
 *  in reverse order.
 *
 *  % java Reverse
 *  1 2 3 4 5
 *  5
 *  4
 *  3
 *  2
 *  1
 ******************************************************************************/
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stack;

public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }
        for (int i : stack) {
            StdOut.println(i);
        }
    }
}

