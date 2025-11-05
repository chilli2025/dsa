package dsaPracs;

import java.util.Scanner;

public class StackApplicationPostfix {

    private int top;
    private int[] s = new int[10];

    public StackApplicationPostfix() {
        top = -1;
    }

    public void push(int x) {
        if (top == s.length - 1) {
            System.out.println("Stack Overflow!");
        } else {
            top = top + 1;
            s[top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return 0;
        } else {
            int x = s[top];
            top = top - 1;
            return x;
        }
    }

    public int evaluate(char operator, int op1, int op2) {
        return switch (operator) {
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> {
                if (op2 == 0) {
                    System.out.println("Error! Division by Zero!");
                    yield 0;
                } else yield op1 / op2;
            }
            case '%' -> op1 % op2;
            default -> {
                System.out.println("Invalid Operator: " + operator);
                yield 0;
            }
        };
    }

    public static void main(String[] args) {
        StackApplicationPostfix obj = new StackApplicationPostfix();
        Scanner sc = new Scanner(System.in);

        System.out.println("Stack Application");
        System.out.print("Enter the Postfix Expression (e.g., 65+ for 6+5): ");
        String expression = sc.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                obj.push(ch - '0');
            } else {
                int op2 = obj.pop();
                int op1 = obj.pop();
                int result = obj.evaluate(ch, op1, op2);
                obj.push(result);
            }
        }

        int finalResult = obj.pop();
        System.out.println("Result of Expression is: " + finalResult);
        sc.close();
    }
}
