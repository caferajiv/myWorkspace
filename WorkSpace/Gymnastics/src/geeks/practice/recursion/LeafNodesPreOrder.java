package geeks.practice.recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LeafNodesPreOrder {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 
		 for(int i=0;i<testcases;i++){
			 
			 int nodes = in.nextInt();
			 int[] arr = new int[nodes];
			 for(int j=0;j<nodes; j++)
			 {
				 arr[j] = in.nextInt();
			 }
		 
			 printLeafNodes(arr);
			
		  }
	}

	private static void printLeafNodes(int[] arr) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int start = 0;
		int end = arr.length-1;
		
		findLeafNodes(arr, start, end, queue);
		
		printStack(queue);
		
	}

	private static void printStack(Queue<Integer> queue) {
		
		while(!queue.isEmpty()){
			System.out.print(queue.poll()+" ");
		}
		System.out.println();
	}

	private static void findLeafNodes(int[] arr, int start, int end, Queue<Integer> queue) {
		if(end<start) return ;
		
		if(start==end){
			queue.offer(arr[start]);
			return;
			
		}
		if(end-start==1){
			queue.offer(arr[end]);
			return;
			
		}
		
		
		int index = findIndexOfNextGreaterElement(arr, start, end);
		
		findLeafNodes(arr, start+1, index-1, queue);
		findLeafNodes(arr, index, end, queue);
		
	}

	private static int findIndexOfNextGreaterElement(int[] arr, int start, int end) {
		
		int root = arr[start];
		for(int i=1;i<=end;i++){
			if(root<arr[i]){
				return i;
			}
		}
		return start+1;
	}

}
