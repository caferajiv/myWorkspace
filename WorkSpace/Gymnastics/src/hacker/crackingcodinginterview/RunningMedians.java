package hacker.crackingcodinginterview;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedians {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int[] inputs = new int[n];
		for(int i =0;i<n;i++) {
			inputs[i] = sc.nextInt();
		}
		for(int i : inputs) {
			System.out.println(findMedian(minHeap,maxHeap,i));
		}
	}

	private static double findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int i) {
		if(maxHeap.isEmpty() && minHeap.isEmpty()) {
			maxHeap.add(i);
			return (double)i;
		}
		if(maxHeap.size()==minHeap.size()) {
			if(i>minHeap.peek()) {
				maxHeap.add(minHeap.poll());
				minHeap.add(i);
			}else{
				maxHeap.add(i);
			}
			
			return maxHeap.peek();

		}else {
			if(!maxHeap.isEmpty() && i<maxHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(i);
			}else {
				minHeap.add(i);
			}

			return (double)(minHeap.peek() + maxHeap.peek())/2;
		} 

		
	}

}
