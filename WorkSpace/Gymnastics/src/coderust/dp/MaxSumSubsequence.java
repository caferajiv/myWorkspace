package coderust.dp;

public class MaxSumSubsequence {
	
	public static void main(String[] args) {
		int[] arr = {1,6,10, 14,-5,-1, 2,-1,3};
		
		System.out.println(find_max_sum_nonadjacent(arr));
	
	}
	
	static int find_max_sum_nonadjacent(int[] arr) {

		int[] max = new int[arr.length];
		
		max[0] = arr[0];
		max[1] = arr[1];
		
		for(int i=2;i<arr.length;i++) {
			
			max[i] = Math.max(arr[i]+max[i-2], max[i-1]);
		}
		
		int maxSum = 0;
		
		for(int i =0;i<max.length;i++) {
			if (maxSum<max[i]) {
				maxSum = max[i];
			}
		}
		
		return maxSum;
	  }

}
