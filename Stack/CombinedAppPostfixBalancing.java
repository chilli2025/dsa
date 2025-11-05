package dsaPracs;

import java.util.Scanner;
import java.util.Stack;

public class CombinedPostfixBalancing {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else if (ch == ' ') {
                continue;
            } else {
                if (stack.size() < 2) {
                    System.out.println("Invalid postfix expression!");
                    return -1;
                }

                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        if (val2 == 0) {
                            System.out.println("Error! Division by zero!");
                            return -1;
                        }
                        stack.push(val1 / val2);
                        break;
                    case '%':
                        stack.push(val1 % val2);
                        break;
                    case '^':
                        stack.push((int) Math.pow(val1, val2));
                        break;
                    default:
                        System.out.println("Invalid operator: " + ch);
                        return -1;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Error: No result found!");
            return -1;
        }

        return stack.pop();
    }

    // Function to check balanced parentheses
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return false;

                char open = stack.pop();
                if ((ch == ')' && open != '(') ||
                    (ch == '}' && open != '{') ||
                    (ch == ']' && open != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Main Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== STACK APPLICATION MENU ======");
            System.out.println("1. Evaluate Postfix Expression");
            System.out.println("2. Check Balanced Parentheses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a postfix expression (e.g. 23*54*+9-): ");
                    String postfix = sc.nextLine();
                    int result = evaluatePostfix(postfix);
                    if (result != -1)
                        System.out.println("Result = " + result);
                }

                case 2 -> {
                    System.out.print("Enter an expression to check parentheses: ");
                    String expr = sc.nextLine();
                    if (isBalanced(expr))
                        System.out.println("Parentheses are BALANCED");
                    else
                        System.out.println("Parentheses are NOT BALANCED");
                }

                case 3 -> System.out.println("Exiting program... Thank you!");

                default -> System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
