package searching_algos;

import java.util.*;
public class BinarySearch {
public static void BinarySearch(int a[], int low, int high, int key)
{
	while(low<=high)
	{
		int mid = (low+high)/2;
		if(key==a[mid])
		{
			System.out.println("Element is found at position : " + (mid+1));
			break;
		}
		else {
			if(key<a[mid])
				high=mid-1;
			
			else
				low=mid+1;
		}
			if(low>high)
				System.out.println("Element is not found!");
			
		
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i, key, f=0, a[], low, high;
		System.out.println("Enter the number of elements");
		int n=sc.nextInt();
		a=new int[n];
		System.out.println("Enter array elements");
		for(i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		System.out.println("Sorted array: " + Arrays.toString(a));
		System.out.println("Enter value to find");
		key=sc.nextInt();
		
		low=0;
		high=n-1;
		BinarySearch(a,low,high,key);
	}
}
