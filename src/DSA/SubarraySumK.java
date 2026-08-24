package DSA;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumK {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) arr[i]=sc.nextInt();
		int k=sc.nextInt();
		
		HashMap<Integer,Integer> hs=new HashMap<>();
		hs.put(0, 1);
		int currsum=0;
		int count=0;
		for(int i=0;i<n;i++) {
			currsum+=arr[i];
			if(hs.containsKey(currsum-k)) {
				count+=hs.get(currsum-k);
			}
			hs.put(currsum,hs.getOrDefault(currsum, 0)+1);
		}
		System.out.println(count);
	}

}
