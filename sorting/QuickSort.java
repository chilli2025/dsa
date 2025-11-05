package sorting;

import java.util.Scanner;

public class QuickSort {
    static int partition(int[] a, int beg, int end) {
        int piv = a[beg];
        int up = end;
        int down = beg;
        int temp;
        while (down < up) {
            while (down < end && a[down] <= piv)
                down++;
            while (a[up] > piv)
                up--;
            if (down < up) {
                temp = a[down];
                a[down] = a[up];
                a[up] = temp;
            }
        }
        temp = a[beg];
        a[beg] = a[up];
        a[up] = temp;
        return up;
    }

    static void sort(int[] a, int beg, int end) {
        if (beg < end) {
            int j = partition(a, beg, end);
            sort(a, beg, j - 1);
            sort(a, j + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sort(a, 0, n - 1);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
