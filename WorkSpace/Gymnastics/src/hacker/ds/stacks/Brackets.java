package hacker.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {
	
	public static void main(String[] args) {
		
		 Stack<Character> bracketStack = new Stack<Character>();
		 Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 String[] testStrings = new String[testcases];
		 String[] resultStrings = new String[testcases];
		 for(int i=0;i<testcases;i++){

			 testStrings[i] = in.next();
		 }
		 for(int k=0;k< testcases ;k++){
			//char[] charArray = testString.toCharArray();
			 String testString = testStrings[k];
			 int length = testString.length();
			 
			for(int j = 0;j<length;j++){
				
				char c = testString.charAt(j);
				if(j==0 && (c==')' || c=='}' || c==']')){
					resultStrings[k]="NO";
					break;
				}
				if(c=='(' || c=='{' || c=='['){
					bracketStack.push(c);
				}else if(c==')' && (bracketStack.isEmpty() || bracketStack.peek()!='(')){
					resultStrings[k] = "NO";
					break;
				}else if(c=='}' && (bracketStack.isEmpty() || bracketStack.peek()!='{')){
					resultStrings[k] = "NO";
					break;
				}else if(c==']' && (bracketStack.isEmpty() || bracketStack.peek()!='[')){
					resultStrings[k] = "NO";
					break;
				}else{
					bracketStack.pop();
				}
			}
			if(bracketStack.isEmpty()){
				resultStrings[k] = "YES";
				
			}
			bracketStack.clear();
			
			 
		 }
		 
		for(String s:resultStrings){
			System.out.println(s);
		}
	}

	

}
