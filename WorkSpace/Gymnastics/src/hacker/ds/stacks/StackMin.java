package hacker.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

public class StackMin {
	static Stack<Integer> sortedStack = new Stack<Integer>();
	//static Stack<Integer> simpleStack = new Stack<Integer>();
	public static void main(String[] args) {
		 Stack<Integer> sortedStack = new Stack<Integer>();
		 Stack<Integer> simpleStack = new Stack<Integer>();
		 Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 sortedStack.push(Integer.MIN_VALUE);
		 for(int i=0;i<testcases;i++){
			 int command = in.nextInt();
			 if(command==1){
				 int item = in.nextInt();
				 simpleStack.push(item);
				 if(item >= sortedStack.peek()){
					 sortedStack.push(item);
				 }
			 }else if(command ==2){
				 int item = simpleStack.pop();
				 if(item==sortedStack.peek()){
					 sortedStack.pop();
				 }
			 }else if(command ==3){
				 System.out.println(sortedStack.peek());
			 }
		 }
		
	}

	private static void pushSorted(int n) {
		
		if(!sortedStack.isEmpty() && n>sortedStack.peek()){
			sortedStack.push(n);
		}else {
			if(!sortedStack.isEmpty()){
				int top = sortedStack.pop();
				pushSorted(n);
				sortedStack.push(top);
			}else {
				sortedStack.push(n);
			}
			
		}
		
		
	}


}
