package pet;

import java.util.Stack;

public class StackReversing {
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(9);
		stack.push(3);
		stack.push(6);
		stack.push(2);
		stack.push(5);
		stack.push(8);
		stack.push(4);
		stack.push(7);
		stack.push(8);
		stack.push(0);
		
		
		
		//System.out.println();
		reverseStack(stack);
		
		
		while(!stack.isEmpty()){
		System.out.print(stack.pop()+" ");
		}
	}

	private static void reverseStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int item = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack,item);
			
		}
		
	}

	private static void insertAtBottom(Stack<Integer> stack, int item) {
		Integer top = null;
		if(!stack.isEmpty()) {
			top = stack.pop();
			insertAtBottom(stack, item);
		}else {
		stack.push(item);
		}
		if(top!=null)
		stack.push(top);
		
	}

}
