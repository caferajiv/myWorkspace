package cracking.recursion;

import java.util.Stack;

public class TowersOfHanoi {
	
	
     
	public static void main(String[] args) {
		
		Stack<Integer> source = new Stack<>();
		Stack<Integer> destination = new Stack<>();
		Stack<Integer> buffer = new Stack<>();

		int n = 6; // Number of disks

		source.push(6);
		source.push(5);
		source.push(4);
		source.push(3);
		source.push(2);
		source.push(1);
		System.out.println(source);
		moveDisks(n,source,destination,buffer);
		System.out.println(destination);

	}

	private static void moveDisks(int n, Stack<Integer> S, Stack<Integer> D, Stack<Integer> B) {

		if(n<=0) return;
		moveDisks(n-1, S, B, D);
		moveTop(S,D);
		moveDisks(n-1, B, D, S);
	}

	private static void moveTop(Stack<Integer> source, Stack<Integer> destination) {
		destination.push(source.pop());
		
	}


}
