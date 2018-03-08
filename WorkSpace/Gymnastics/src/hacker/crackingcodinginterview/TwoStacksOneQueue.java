package hacker.crackingcodinginterview;

import java.util.Scanner;
import java.util.Stack;

public class TwoStacksOneQueue {
	
	public static void main(String[] args) {
		Stack<Integer> pushStack = new Stack<>();
		Stack<Integer> popStack = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n>0) {
			int cmd = sc.nextInt();
		if(cmd == 1) {
			int item = sc.nextInt();
			enqueue(pushStack, popStack, item);
		}else if(cmd==2) {
			dequeue(pushStack,popStack);
		}else if(cmd==3) {
			display(pushStack,popStack);
		}
		n--;
		}
		
		
		
	}

	private static void display(Stack<Integer> push, Stack<Integer> pop) {
		if(pop.isEmpty()) {
			while(!push.isEmpty()) {
				pop.push(push.pop());
			}
		}
		System.out.println(pop.peek());
	}

	private static void dequeue(Stack<Integer> push, Stack<Integer> pop) {
		if(pop.isEmpty()) {
			while(!push.isEmpty()) {
				pop.push(push.pop());
			}
		}
		pop.pop();
		
	}

	private static void enqueue(Stack<Integer> push, Stack<Integer> pop, int item) {
		
		push.push(item);
	}

}
