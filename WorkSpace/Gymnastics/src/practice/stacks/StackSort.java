package practice.stacks;

import java.util.Stack;

public class StackSort {
	
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
		
		sortStack(stack);
		
		//display(aux);
		
	}

	private static void sortStack(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		Stack<Integer> aux = new Stack<Integer>();
		while(!stack.isEmpty()){
			int item = stack.pop();
			insert(aux, item);
		}
		//stack = aux;
		display(aux);
		
	}

	private static void insert(Stack<Integer> aux, int item) {
		if(!aux.isEmpty()){
			int v = aux.peek();
			if(v<item){
				int s = aux.pop();
				insert(aux,item);
				aux.push(s);
			}else{
				aux.push(item);
			}
		}else{
			aux.push(item);
		}
	}

	private static void display(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		
	}

}
