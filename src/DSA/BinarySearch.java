package DSA;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		System.out.println("Enter the size of array");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter Array  elements in ascendig:");
		for(int i=0;i<n;i++) arr[i]=scanner.nextInt();
		System.out.println("Enter target Element:");
		int target=scanner.nextInt();
		int index=binarysearch(arr,0,n-1,target);
		System.out.println(index);
	}

	public static int binarysearch(int[] arr, int l, int r,int target) {
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(arr[mid]==target) return mid;
			else if(arr[mid]>target) {
				r=mid-1;
			}else l=mid+1;
		}
		return -1;
	}

}
