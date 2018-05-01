package practice.search.sort;

import java.util.Arrays;

public class SumOf2Closest0 {
public static void main(String[] args) {
		
		int[] arr = {1,60,-10,70,-80,85};
		
		int K = 0;
		int low = 0;
		int high = arr.length-1;
		System.out.println(findSumOf2Closest0(arr,low, high, K));
	}

	private static int  findSumOf2Closest0(int[] arr, int low, int high, int K) {
		Arrays.sort(arr);
		int minSum = Integer.MAX_VALUE;
		
		while(low<high) {
			int tempSum = arr[low] + arr[high];
			
			if(tempSum>0) {
				minSum = Math.min(tempSum, minSum);
				high--;
			}else {
				minSum = Math.min(Math.abs(tempSum), minSum);
				low++;
			}
		}
		
		return minSum;
	}

}
