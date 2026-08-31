package DSA;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSUM {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter size of the array:");
		int n=scanner.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter elements:");
		for(int i=0;i<n;i++) arr[i]=scanner.nextInt();
		List<List<Integer>> res=threeSum(arr);
		System.out.println(res.toString());
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		Arrays.sort(nums);
		int n=nums.length;
		for(int i=0;i<n;i++) {
			if(i!=0 && nums[i]==nums[i-1]) continue;
			if(nums[i]>0) break;
			int j=i+1;
			int k=n-1;
			while(j<k) {
				int sum=nums[i]+nums[j]+nums[k];
				if(sum>0) {
					k--;
				}
				else if(sum<0) {
					j++;
				}
				else {
					res.add(Arrays.asList(nums[i],nums[j],nums[k]));
					j++;
					k--;
					while(j<k && nums[j]==nums[j-1]) {
						j++;
					}
				}
			}
		}
		return res;
	}

}
