package hacker.ds.heaps;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Qheap {
	
	public static void main(String[] args) {

		 PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		 Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 
		 for(int i=0;i<testcases;i++){
			 int command = in.nextInt();
			 if(command==1){
				 int item = in.nextInt();
				 heap.add(item);

			 }else if(command ==2){
				 int item = in.nextInt();
				 heap.remove(item);

			 }else if(command ==3){
				System.out.println(heap.peek());
				 
			 }
		 }
		
	
	
		
	}

}
