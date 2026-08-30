package DSA;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateParentheses {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter n value");
		int n=scanner.nextInt();
		ArrayList<String> res=new ArrayList<>();
		generate("",0,0,res,n);
		for(String x:res) {
			System.out.print(x+" ");
		}
	}

	private static void generate(String string, int open, int close, ArrayList<String> res, int n) {
		if(string.length()==2*n) {
			res.add(string);
			return;
		}
		if(open<n) generate(string+'(',open+1,close,res,n);
		if(close<open) generate(string+')',open,close+1,res,n);
		
	}

}
