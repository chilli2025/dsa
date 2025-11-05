package sorting;

import java.util.Scanner;

public class SelectionSort {
    static void Sort(int[] a, int n) {
        int i, j, min_index, temp;
        for (i = 0; i < n - 1; i++) {
            min_index = i;
            for (j = i + 1; j < n; j++) {
                if (a[min_index] > a[j]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                temp = a[i];
                a[i] = a[min_index];
                a[min_index] = temp;
            }
        }
        System.out.println("Array after selection sort:");
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
