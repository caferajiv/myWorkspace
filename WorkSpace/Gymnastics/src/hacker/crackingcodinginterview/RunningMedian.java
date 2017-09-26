package hacker.crackingcodinginterview;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        
	        findRunningMedian(a);
	}

	private static void findRunningMedian(int[] a) {
		double median = 0.0;
		PriorityQueue<Double> minHeap = new PriorityQueue<>();
		PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(double i : a) {
			if(maxHeap.size()==0 && minHeap.size()==0) {
				minHeap.offer(i);
				median = i;
				System.out.println(median);
			}else if(maxHeap.size()==minHeap.size()) { //even case 
				if(i<maxHeap.peek()) {
					maxHeap.offer(i);
					minHeap.offer(maxHeap.poll());
				}else {
					minHeap.offer(i);
				}
				median =minHeap.peek();
				System.out.println(median);
				
			}else {                                   // odd case
				if(i>minHeap.peek()) {
					minHeap.offer(i);
					maxHeap.offer(minHeap.poll());
				}else {
					maxHeap.offer(i);
				}
				median =(minHeap.peek()+maxHeap.peek())/2;
				System.out.println(median);
			}
			
		}
		
	}

}
