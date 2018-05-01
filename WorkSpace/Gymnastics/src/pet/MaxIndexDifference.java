package pet;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxIndexDifference {
	
	public static void main(String[] args) {
		
		int[] arr = {34,8,10,3,2,80,30,33,1};
		
		System.out.println(findMaxIndexDiff(arr));
	}

	/**
	 * find max (j-i) such that arr[j]>arr[i] and j>i
	 * @param arr
	 * @return
	 */
	private static int findMaxIndexDiff(int[] arr) {

		int maxDiff;
		int i,j;
		int[] leftMins = new int[arr.length];
		int[] rightMaxs = new int[arr.length];
		leftMins[0] = arr[0];
		for(i=1;i<arr.length;i++) {
			leftMins[i] = Math.min(arr[i], leftMins[i-1]);
		}

		for(int a : leftMins)
		{
			System.out.print(a+ " ");
		}
		rightMaxs[arr.length-1] = arr[arr.length-1];
		
		for(j=arr.length-2;j>=0;j--) {
			rightMaxs[j] = Math.max(arr[j], rightMaxs[j+1]);
		}
		
		System.out.println();
		for(int a : rightMaxs)
		{
			System.out.print(a+ " ");
		}
		System.out.println();
		i=0;j=0;maxDiff=-1;
		while(i<arr.length && j<arr.length) {
			if(leftMins[i]<rightMaxs[j]) {
				maxDiff = Math.max(maxDiff, j-i);
				j++;
			}else {
				i++;
			}
			
		}
		System.out.println("i: "+i+ " j: "+j);
		return maxDiff;
	}

}
