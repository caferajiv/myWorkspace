package amazon;

import java.util.Stack;

public class PostfixToPrefix {
	
	private static Stack<String> st = new Stack<String>();
	private static StringBuilder finalString = new StringBuilder();
	
	public static void main(String[] args) {
		String postExpr="42^3*3-84/11+/+";
		System.out.println("Postfix.."+postExpr);
		processString(postExpr);
		System.out.println("Prefix.."+finalString);
	}

	private static void processString(String expr) {
		char [] charArray=expr.toCharArray();
		System.out.println(charArray);
		for(char ch: charArray)
		{
			processChar(ch);
		}
		
		while(!st.isEmpty())
		{
			finalString.append(st.pop());
		}
		
	}

	private static void processChar(char ch) {
		
		if(isOperand(ch))
		{
			st.push(String.valueOf(ch));
		}
		else if(isOperator(ch))
		{
			processOperator(ch);
		}
				
	}

	private static void processOperator(char ch) {

		String operand2=st.pop();
		String operand1= st.pop();
		String str = String.valueOf(ch)+ operand1 + operand2;
		st.push(str);
					
	}

	private static boolean isOperator(char ch) {
		switch(ch)
		{
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return true;
		default:
			return false;
		}
	}
	
	private static boolean isOperand(char ch) {
		if((ch>=48 && ch<=57)|| ch=='.')
		{
			return true;
		}
		return false;
	}
	

}
