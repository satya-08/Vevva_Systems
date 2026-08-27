package DSA;

import java.util.Scanner;
import java.util.Stack;
public class ValidParentheses {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String: ");
		String str=scanner.next();
		System.out.println(isValid(str));
	}

	private static boolean isValid(String str) {
		Stack<Character> stack =new Stack<>();
		for(char ch:str.toCharArray()) {
			if(stack.isEmpty() && (ch==')'||ch=='}'||ch==']')) return false;
			if(ch=='{'||ch=='('||ch=='[') stack.push(ch);
			else {
				if(ch=='}' && stack.peek()=='{') stack.pop();
				else if(ch==']' && stack.peek()=='[') stack.pop();
				else if(ch==')' && stack.peek()=='(') stack.pop();
				else return false;
			}
		}
		return stack.isEmpty();
	}

}
