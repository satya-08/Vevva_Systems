package DSA;

import java.util.Scanner;

public class MaxProfit {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter size of the array");
		int n=scanner.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter the stock prices");
		for(int i=0;i<n;i++) arr[i]=scanner.nextInt();
		System.out.println("Profit = "+maxProfit(arr));
	}

	private static int maxProfit(int[] arr) {
		int profit=0;
		int n=arr.length;
		int maxPrice=arr[n-1];
		for(int i=n-2;i>=0;i--) {
			profit=Math.max(profit,maxPrice-arr[i]);
			if(maxPrice<arr[i]) maxPrice=arr[i];
		}
		return profit;
	}

}
