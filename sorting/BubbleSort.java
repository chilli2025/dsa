package sorting;

import java.util.Scanner;

public class BubbleSort {
	static void sort(int[] a, int n) {
		int temp = 0;
		int k, j;
		for (int i = 0; i < n; i++) {
			for (j = 0; j < (n - 1 - i); j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println("Array elements after bubble sort are: ");
		for (k = 0; k < n; k++) {
			System.out.println(a[k] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter array size : ");
		n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter array elements : ");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sort(a, n);
	}
}