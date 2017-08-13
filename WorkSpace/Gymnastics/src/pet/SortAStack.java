package pet;

import java.util.Stack;

public class SortAStack {
	
	public static void main(String[] args) {
		Stack stack = new Stack();
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
		
		/*while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}*/
		
		sortStack(stack);
		
		while(!stack.isEmpty()){
		System.out.println(stack.pop());
		}
	}

	private static void sortStack(Stack stack) {
		
		Stack temp = new Stack();
		while(!stack.isEmpty()){
			int data = (Integer)stack.pop();
			while(!temp.isEmpty() && (Integer)temp.peek()>data){
				stack.push(temp.pop());
			}
			temp.push(data);
		}
		
		while(!temp.isEmpty()){
		stack.push(temp.pop());
		}
		
	}

}
