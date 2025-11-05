package dsaPracs;

import java.util.Scanner;

public class StackOperations {

    private int top;
    int s[] = new int[10]; // Stack size 10

    public StackOperations() {
        top = -1;
    }

    public void push() {
        Scanner sc = new Scanner(System.in);
        if (top == s.length - 1)
            System.out.println("Stack Overflow");
        else {
            System.out.println("Please enter the value:");
            int x = sc.nextInt();
            top = top + 1;
            s[top] = x;
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            int x = s[top];
            System.out.println("The popped value is: " + x);
            top--;
        }
    }

    public void isFull() {
        if (top == s.length - 1)
            System.out.println("Stack is full (Overflow)");
        else
            System.out.println("Stack is not full");
    }

    public void isEmpty() {
        if (top == -1)
            System.out.println("Stack is empty");
        else
            System.out.println("Stack is not empty");
    }

    public void display() {
        if (top == -1)
            System.out.println("Stack is empty");
        else {
            System.out.println("Elements in stack are:");
            for (int i = top; i >= 0; i--)
                System.out.println(s[i] + " ");
        }
    }

    public void count() {
        if (top == -1)
            System.out.println("Stack is empty");
        else {
            int c = top + 1;
            System.out.println("Number of elements in stack: " + c);
        }
    }

    public static void main(String[] args) {
        StackOperations obj = new StackOperations();
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1: Push 2: Pop 3: Is Full 4: Is Empty 5: Display 6: Count 7: Exit");
            System.out.print("Enter Your Choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> obj.push();
                case 2 -> obj.pop();
                case 3 -> obj.isFull();
                case 4 -> obj.isEmpty();
                case 5 -> obj.display();
                case 6 -> obj.count();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 7);

        sc.close();
    }
}
