package geeks.practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 
		 for(int i=0;i<testcases;i++){
			 int size = in.nextInt();
			 Stack<Integer> stack = new Stack<Integer>();
			 for(int j=0;j<size;j++){
				 stack.push(in.nextInt());
			 }
			 sortStack(stack);

			 while(!stack.isEmpty()){
				 System.out.print(stack.pop()+" ");
				 
			 }
			 System.out.println();
		 }
	
		
		
	}
	
	public Stack<Integer> sort(Stack<Integer> s)
	{

		Stack<Integer> temp = new Stack<Integer>();
		while(!s.isEmpty()){
			int data = s.pop();
			while(!temp.isEmpty() && temp.peek()<data){
				s.push(temp.pop());
			}
			temp.push(data);
		}

		while(!temp.isEmpty()){
			s.push(temp.pop());
		}

		return s;
	}

	private static void sortStack(Stack<Integer> stack) {
		
		Stack<Integer> temp = new Stack<Integer>();
		while(!stack.isEmpty()){
			int data = (Integer)stack.pop();
			while(!temp.isEmpty() && (Integer)temp.peek()<data){
				stack.push(temp.pop());
			}
			temp.push(data);
		}
		
		while(!temp.isEmpty()){
		stack.push(temp.pop());
		}
		
	}


	

}
