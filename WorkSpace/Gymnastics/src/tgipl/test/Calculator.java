package tgipl.test;

import java.util.Stack;

public class Calculator {
	
	private static Stack<Character> st = new Stack<Character>();
	private static Stack<String> stString = new Stack<String>();
	private static StringBuilder finalString = new StringBuilder();
	private static StringBuilder finalStringEval = new StringBuilder();
	
	public static void main(String[] args) {
		
		String infixString="((2+8)*9)-(5*(5+2))";
		System.out.println(solve_binarytree(infixString));
	}

	public static int solve_binarytree(String infixString)
    {
		processString(infixString);
		String evalString=finalString.toString();
		System.out.println(evalString);
		processStringEval(evalString);
		//System.out.println(finalStringEval.toString());
        return (int)Double.parseDouble(finalStringEval.toString());
    }
	
	private static void processString(String expr) {
		char [] charArray=expr.toCharArray();
		//System.out.println(charArray);
		for(char ch : charArray)
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
			finalString.append(ch);
		}
		else if(isOperator(ch))
		{
			processOperator(ch);
		}
		else if(ch==')')
		{
			char pop=st.pop();
			while(pop!='(')
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
		else if(ch=='(')
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
		
		if(getPriority(ch)<=getPriority(pop))
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
		if((ch>=48 && ch<=57)|| ch=='.')
		{
			return true;
		}
		return false;
	}
	
	private static void processStringEval(String expr) {
		char [] charArray=expr.toCharArray();
		//System.out.println(charArray);
		for(char ch: charArray)
		{
			processCharEval(ch);
		}
		
		while(!stString.isEmpty())
		{
			finalStringEval.append(stString.pop());
		}
		
	}

	private static void processCharEval(char ch) {
		
		if(isOperand(ch))
		{
			stString.push(String.valueOf(ch));
		}
		else if(isOperator(ch))
		{
			processOperatorEval(ch);
		}
				
	}

	private static void processOperatorEval(char ch) {

		String operand2=stString.pop();
		String operand1= stString.pop();
		Double one = Double.parseDouble(operand1);
		Double two = Double.parseDouble(operand2);
		Double value = performOperation(one,two,ch);
		//String str = operand1 +String.valueOf(ch)+operand2;
		stString.push(String.valueOf(value));
					
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

	
	
	
	
}
