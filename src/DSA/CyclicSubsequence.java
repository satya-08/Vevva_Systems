package DSA;

import java.util.Scanner;

public class CyclicSubsequence {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter String1");
		String str1=scanner.next();
		System.out.println("Enter String2");
		String str2=scanner.next();
		System.out.println(str1+" Is Subsequence of "+str2+" :"+iscyclicsubsequence(str1,str2));
	}

	private static boolean iscyclicsubsequence(String str1, String str2) {
		// TODO Auto-generated method stub
		int l=0;
		int r=0;
		int l1=str1.length();
		int l2=str2.length();
		while(l1>l && l2>r) {
			char ch1=str1.charAt(l);
			char ch2=str2.charAt(r);
			char next=(char)(ch1+1);
			if(ch1=='z') next='a';
			if(ch1==ch2 ||next==ch2) {
				l++;
				r++;
			}else {
				l++;
			}
		}
		return r==l2;
	}

}
