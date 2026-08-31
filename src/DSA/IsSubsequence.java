package DSA;

import java.util.Scanner;

public class IsSubsequence {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter String1");
		String str1=scanner.next();
		System.out.println("Enter String2");
		String str2=scanner.next();
		System.out.println(str1+" Is Subsequence of "+str2+" :"+issubsequence(str1,str2));
		
	}

	private static boolean issubsequence(String str1, String str2) {
		int l=0;
		int r=0;
		int l1=str1.length();
		int l2=str2.length();
		while(l1>l && l2>r) {
			if(str1.charAt(l)==str2.charAt(r)) {
				l++;
				r++;
			}else {
				r++;
			}
		}
		return l==l1;
	}
}
