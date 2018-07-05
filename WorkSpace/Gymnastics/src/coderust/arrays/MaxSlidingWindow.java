package coderust.arrays;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 3, 2, 1, 2, 5};
		int window_size = 4;
 		//System.out.println(find_max_sliding_window(arr,4));  //O(nlogw)
		 //[4, 4, 4, 4, 3, 5]
 		
 		System.out.println(find_max_sliding_windowBetter(arr,4));  //O(n)
	}
	
	private static ArrayDeque<Integer> find_max_sliding_window(
		    int[] arr, 
		    int window_size) {
		    ArrayDeque<Integer> window = new ArrayDeque<Integer>();
		    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		    int i = 0;
		    while(i<window_size){
		       window.offer(arr[i]);
		       maxHeap.offer(arr[i]);
		       i++;
		    }
		    ArrayDeque<Integer> result = new ArrayDeque<Integer>();
		    
		    int max = maxHeap.peek();
		    result.offer(max);
		    
		    int val = window.poll();
		    maxHeap.remove(val);
		    
		    for(;i<arr.length;i++){
		      window.offer(arr[i]);
		      maxHeap.offer(arr[i]);
		      
		      max = maxHeap.peek();
			  result.offer(max);
			  val = window.poll();
			  maxHeap.remove(val);
		      
		    }
		    
		    return result;
		  }
	
	
	
	private static ArrayDeque<Integer> find_max_sliding_windowBetter(
		    int[] arr, 
		    int window_size) {

		ArrayDeque<Integer> result = new ArrayDeque<Integer>();

		ArrayDeque<Integer> window = new ArrayDeque<Integer>();
		window.offer(arr[0]);
		int i = 1;
		while(!window.isEmpty() && i<window_size){
			if(window.peekLast()<arr[i]) {
				window.pollLast();
				window.offer(arr[i]);
			}else {
				window.offer(arr[i]);
			}
			i++;
		}

		result.offer(window.peekFirst());

		for(;i<arr.length;i++){
			while(!window.isEmpty() && window.peekLast()<arr[i]) {
				window.pollLast();
			}
			window.offer(arr[i]);
			if(window.size()>=window_size) {
				result.offer(window.pollFirst());
			}else {
				result.offer(window.peekFirst());
			}
			
		}

		return result;
	}
	

}
