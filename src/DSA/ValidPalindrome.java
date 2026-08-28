package DSA;

public class ValidPalindrome {
	public static void main(String[] args) {
		String str="A man, a plan, a canal: Panama";
		System.out.println(str);
		System.out.println(validpalindrome(str));
	}

	public static boolean validpalindrome(String str) {
//		str=str.toLowerCase();
//		str=str.replaceAll("[^A-Za-z0-9]", "");
//		int l=0;;
//		int r=str.length()-1;
//		while(l<r) {
//			if(str.charAt(l)!=str.charAt(r)) return false;
//			l++;
//			r--;
//		}
//		return true;  TC : More
		
		// To reduce TC
		str=str.toLowerCase();
		int l=0;
		int r=str.length()-1;
		while(l<r) {
			if(!Character.isLetterOrDigit(str.charAt(l))) {
				l++;
				continue;
			}
			if(!Character.isLetterOrDigit(str.charAt(r))) {
				r--;
				continue;
			}
			if(str.charAt(l)!=str.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}

}
