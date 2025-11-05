package queue;

import java.util.Scanner;

public class LinearQueue {
    int[] a;
    int front, rear;

    public LinearQueue(int size) {
        a = new int[size];
        front = rear = -1;
    }

    public void insert(Scanner sc) {
        if (rear == a.length - 1) {
            System.out.println("Linear queue is full");
            return;
        }
        System.out.println("Enter element to be inserted in the queue:");
        int item = sc.nextInt();
        rear++;
        a[rear] = item;
        if (front == -1) {
            front = 0;
        }
    }

    public void delete() {
        if (front == -1) {
            System.out.println("Linear queue is empty!");
            return;
        }
        System.out.println("Deleted element is: " + a[front]);
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }

    public void count() {
        if (front == -1) {
            System.out.println("Linear queue is empty!");
        } else {
            System.out.println("Number of elements in the linear queue: " + (rear - front + 1));
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Linear queue is empty!");
            return;
        }
        System.out.print("Elements in the linear queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue:");
        int size = sc.nextInt();
        LinearQueue q = new LinearQueue(size);

        int ch;
        do {
            System.out.println("\n1. Insert 2. Delete 3. Count 4. Display 5. Exit");
            System.out.println("Enter choice:");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    q.insert(sc);
                    break;
                case 2:
                    q.delete();
                    break;
                case 3:
                    q.count();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exiting program!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (ch != 5);

        sc.close();
    }
}
