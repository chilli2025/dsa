package queue;

import java.util.Scanner;

public class CircularQueue {
    int[] arr;
    int front, rear;
    final int MAX;

    public CircularQueue(int size) {
        MAX = size;
        arr = new int[MAX];
        front = rear = -1;
    }

    public void insert(Scanner sc) {
        if ((rear + 1) % MAX == front) {
            System.out.println("Circular queue is full!");
            return;
        }
        System.out.println("Enter element to insert:");
        int item = sc.nextInt();
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % MAX;
        arr[rear] = item;
    }

    public void dequeue() {
        if (front == -1) {
            System.out.println("Circular queue is empty!");
            return;
        }
        System.out.println("Deleted element: " + arr[front]);
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX;
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Circular queue is empty!");
            return;
        }
        System.out.print("Elements in circular queue: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % MAX;
        }
        System.out.println();
    }

    public void count() {
        if (front == -1) {
            System.out.println("Circular queue is empty!");
            return;
        }
        int count = (rear - front + MAX) % MAX + 1;
        System.out.println("Number of elements in circular queue: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of circular queue:");
        int size = sc.nextInt();
        CircularQueue q = new CircularQueue(size);

        int ch;
        do {
            System.out.println("\n1: Insert  2: Dequeue  3: Count  4: Display  5: Exit");
            System.out.println("Enter choice:");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> q.insert(sc);
                case 2 -> q.dequeue();
                case 3 -> q.count();
                case 4 -> q.display();
                case 5 -> System.out.println("Exiting program!");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 5);

        sc.close();
    }
}
