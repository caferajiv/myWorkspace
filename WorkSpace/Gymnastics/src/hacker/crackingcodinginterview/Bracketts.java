package hacker.crackingcodinginterview;

import java.util.Scanner;
import java.util.Stack;

public class Bracketts {
	
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.next();
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(isBalanced(arr[i]));
		}
	
	
		
	}

	private static String isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(isClosingBracket(c)) {
				if(!stack.isEmpty()) {
					if(stack.peek()==pairOf(c)) {
						stack.pop();
					}else {
						return "NO";
					}
				}else {
					return "NO";
				}
			}else {
				stack.push(c);
			}
		}
		
		if(stack.isEmpty()) return "YES";
		return "NO";
		
	}

	private static char pairOf(char c) {
		if(c==')') return '(';
		else if(c=='}') return '{';
		else if(c==']') return '[';
		return ' ';
	}

	private static boolean isClosingBracket(char c) {
		return c==')' || c=='}' || c==']';
	}

}
