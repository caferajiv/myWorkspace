package pet;

import java.util.Scanner;
import java.util.Stack;

public class StackMin {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		for(int i = 0;i <testcases ; i++){
			Stack<Integer> stack = new Stack<Integer>();
			Stack<Integer> minStack = new Stack<Integer>();
			int queries = in.nextInt();
			for(int j =0;j<queries;j++){
				int command = in.nextInt();
				if(command == 1){
					int num = in.nextInt();
					pushAndProcess(stack,minStack,num);
					stack.push(num);
				}else if(command == 2){
					int pop = popAndProcess(stack,minStack);
					System.out.print(pop+" ");	 
				}else if(command ==3){
					System.out.print(minStack.peek()+" ");
				}
			}
		}
	
	}

	private static int popAndProcess(Stack<Integer> stack, Stack<Integer> minStack) {
		
		int pop =-1;
		if(!stack.isEmpty()){
			 pop = stack.pop();
			 if(pop == minStack.peek()){
				 minStack.pop();
			 }
		}
		return pop;
	}

	private static void pushAndProcess(Stack<Integer> stack, Stack<Integer> minStack, int num) {
		if(stack.isEmpty()){
			stack.push(num);
			minStack.push(num);
			
		}else{
			stack.push(num);
			if(minStack.peek()>=num){
				minStack.push(num);
			}
		}
		
	}


}
