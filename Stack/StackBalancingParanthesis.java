package dsaPracs;

import java.util.Scanner;

public class StackBalancingParanthesis {

    private int top;
    private char[] s = new char[100]; // Increased size for longer expressions

    public StackBalancingParanthesis() {
        top = -1;
    }

    public void push(char x) {
        if (top == s.length - 1) {
            System.out.println("Stack Overflow!");
        } else {
            top = top + 1;
            s[top] = x;
        }
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return '\0';
        } else {
            char x = s[top];
            top = top - 1;
            return x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackBalancingParanthesis stack = new StackBalancingParanthesis();

        System.out.println("Why Need Balance?");
        System.out.print("Enter Expression String: ");
        String exp = sc.nextLine();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                char a = stack.pop();

                if ((ch == ')' && (a == '{' || a == '[')) ||
                    (ch == ']' && (a == '{' || a == '(')) ||
                    (ch == '}' && (a == '(' || a == '['))) {

                    System.out.println("Unbalanced Parenthesis!");
                    sc.close();
                    return;
                }
            }
        }

        if (stack.top == -1) {
            System.out.println("Parentheses are Balanced!");
        } else {
            System.out.println("Unbalanced Parenthesis!");
        }

        sc.close();
    }
}
