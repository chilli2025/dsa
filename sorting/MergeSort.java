package sorting;

import java.util.Scanner;

public class MergeSort {
    public static void merge(int[] a, int low, int mid, int high) {
        int h = low, i = low, j = mid + 1;
        int[] b = new int[a.length];

        while (h <= mid && j <= high) {
            if (a[h] <= a[j]) {
                b[i++] = a[h++];
            } else {
                b[i++] = a[j++];
            }
        }

        while (h <= mid) {
            b[i++] = a[h++];
        }

        while (j <= high) {
            b[i++] = a[j++];
        }

        for (int k = low; k <= high; k++) {
            a[k] = b[k];
        }
    }

    public static void sort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter array elements:");
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
