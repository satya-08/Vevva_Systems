package DSA;

import java.util.Scanner;

public class ValidAnagram {
	public static void main(String[] args) {
		System.out.println("Enter first string:");
		Scanner scanner=new Scanner(System.in);
		String str1=scanner.next();
		System.out.println("Enter second string:");
		String str2=scanner.next();
		System.out.println(validanagram(str1,str2));
		
	}

	private static boolean validanagram(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		if(m!=n) return false;
		int freq[]=new int[26];
		for(int i=0;i<n;i++) {
			freq[str1.charAt(i)-'a']++;
			freq[str2.charAt(i)-'a']--;
		}
		for(int i=0;i<26;i++) {
			if(freq[i]!=0) return false;
		}
		return true;
	}

}
