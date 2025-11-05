package sorting;

import java.util.Scanner;

public class InsertionSort {
    static void Sort(int[] a, int n) {
        int PTR, i, temp;
        for (i = 1; i < n; i++) {
            temp = a[i];
            PTR = i - 1;
            while (PTR >= 0 && temp < a[PTR]) {
                a[PTR + 1] = a[PTR];
                PTR = PTR - 1;
            }
            a[PTR + 1] = temp;
        }
        System.out.println("Array after insertion sort:");
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Sort(a, n);
        sc.close();
    }
}
