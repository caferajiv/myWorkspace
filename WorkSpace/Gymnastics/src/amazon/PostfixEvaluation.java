package amazon;

import java.util.Stack;

public class PostfixEvaluation {
	
	private static Stack<String> st = new Stack<String>();
	private static StringBuilder finalString = new StringBuilder();
	
	public static void main(String[] args) {
		String postExpr="42^3*3-84/11+/+";
		System.out.println("Postfix.."+postExpr);
		processString(postExpr);
		System.out.println("Infix.."+finalString);
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
		Double one = Double.parseDouble(operand1);
		Double two = Double.parseDouble(operand2);
		Double value = performOperation(one,two,ch);
		//String str = operand1 +String.valueOf(ch)+operand2;
		st.push(String.valueOf(value));
					
	}

	private static Double performOperation(Double one, Double two,
			char ch) {
		switch(ch)
		{
		case '+':
			return one + two;
		case '-':
			return one - two;
		case '*':
			return one * two;
		case '/':
			return one / two;
		case '^':
			return (double)(one.intValue() ^ two.intValue());
			
		default:
			return 0.0;
		}
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
