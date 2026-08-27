package DSA;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter size of the array");
		int n=scanner.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter Values:");
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter the Target value");
		int target=scanner.nextInt();
		int[] res=twosum(arr,target);
		System.out.println("[ "+res[0]+" "+res[1]+" ]");
	}

	private static int[] twosum(int[] arr, int target) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int com=target-arr[i];
			if(map.containsKey(com)) {
				return new int[] {map.get(com),i};
			}
			map.put(arr[i],i);
		}
		return new int[] {};
	}

}
