package practice.stacks;

import java.util.Stack;

import pet.ReverseString;

public class StackReversal {
	
	public static void main(String[] args) {

		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(4);
		stack.push(2);
		stack.push(8);
		stack.push(6);
		stack.push(1);
		stack.push(5);
		stack.push(9);
		stack.push(10);
		stack.push(3);
		stack.push(7);
		
		//display(stack);
		
		reverseStack(stack);
		
		display(stack);
		
	
	}

	private static void reverseStack(Stack<Integer> stack) {
		if(!stack.isEmpty()){
			int v = stack.pop();
			reverseStack(stack);
			
			insertAtBottom(stack,v);
		}
		
	}
	
	
	private static void insertAtBottom(Stack<Integer> stack, int v) {
		if(!stack.isEmpty()){
			int s = stack.pop();
			insertAtBottom(stack, v);
			stack.push(s);
		}else{
			stack.push(v);
		}
		
	}

	private static void display(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		
	}

}
