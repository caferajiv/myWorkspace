package amazon;

import java.util.Stack;

public class InfixToPrefix {
	
	private static Stack<Character> st = new Stack<Character>();
	private static StringBuilder finalString = new StringBuilder();
	
	public static void main(String[] args) {
		//String expr="4^2*3-3+8/4/(1+1)";
		String expr="((A+B)*C)-(D*(E+F))";
		System.out.println("Infix.."+expr);
		processString(expr);
		System.out.println("Prefix.."+finalString.reverse());
	}

	private static void processString(String expr) {
		char [] charArray=expr.toCharArray();
		System.out.println(charArray);
		for(int i=charArray.length-1;i>=0;i--)
		{
			processChar(charArray[i]);
		}
		
		while(!st.isEmpty())
		{
			finalString.append(st.pop());
		}
		
	}

	private static void processChar(char ch) {
		
		if(isOperand(ch))
		{
			finalString.append(ch);
		}
		else if(isOperator(ch))
		{
			processOperator(ch);
		}
		else if(ch=='(')
		{
			char pop=st.pop();
			while(pop!=')')
			{
				finalString.append(pop);
				if(!st.isEmpty())
				{
				pop=st.pop();
				}else
				{
					break;
				}
			}
		}
		else if(ch==')')
		{
			st.push(ch);
		}
		
	}

	private static void processOperator(char ch) {

		char pop;
		if(!st.isEmpty())
		{
			pop=st.pop();
			compareOperators(ch,pop);
		}else
		{
			st.push(ch);
		}
			
	}

	private static void compareOperators(char ch, char pop) {
		
		if(getPriority(ch)<getPriority(pop))
		{
			finalString.append(pop);
			if(!st.isEmpty())
			{
				pop=st.pop();
				compareOperators(ch,pop);
			}
			else
			{
				st.push(ch);
			}
		
		}
		else
		{	
			st.push(pop);
			st.push(ch);
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
	
	private static int getPriority(char ch)
	{
		switch(ch)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}

	private static boolean isOperand(char ch) {
		if((ch>=48 && ch<=57)||(ch>=65 && ch<=122) ||ch=='.')
		{
			return true;
		}
		return false;
	}
	

}
