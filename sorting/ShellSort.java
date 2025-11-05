package sorting;

import java.util.Scanner;

public class ShellSort{
    static void sort(int[] a, int n, int[] inc, int numinc) {
        for (int incIndex = 0; incIndex < numinc; incIndex++) {
            int span = inc[incIndex];
            System.out.println("Span value: " + span);
            for (int j = span; j < n; j++) {
                int y = a[j];
                int k;
                for (k = j - span; k >= 0 && y < a[k]; k -= span) {
                    a[k + span] = a[k];
                }
                a[k + span] = y;
            }
            System.out.println("Array after span " + span + ":");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
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
        int[] inc = {5, 3, 1};
        int numinc = inc.length;
        sort(a, n, inc, numinc);
        sc.close();
    }
}
