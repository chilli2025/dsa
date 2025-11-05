package searching_algos;

import java.util.Scanner;
public class LinearSearch{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, n, key, f=0, a[];
		System.out.println("Enter the Size of the array: ");
		n = sc.nextInt();
		a = new int [n];
		System.out.println("Enter the elements of the array: ");
		for(i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("Enter the element to be finded: ");
		key = sc.nextInt();
		for(i=0;i<n;i++) {
			if(key==a[i]) {
				f=1;
				break;
			}
		}
		if(f==1) {
			System.out.println("Element Found at: " + i+1);			
		}else {
			System.out.println("Element does not found in the array");
		}
	}
}