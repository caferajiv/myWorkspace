package pet;

import java.util.ArrayList;
import java.util.List;

public class GreatestSum {
	
	public static void main(String[] args) {
		 int arr[] = {1, -2, 3, 10, -4, 7, 2, -5};
		 //greatest sum in the continuous sub-array
		 Integer[]  maxSubArray = findMaxSubArray(arr);
		 for(int n : maxSubArray){
			 System.out.print(" ");
			 System.out.print(n);
		 }
		 
		
		
	}

	private static Integer[] findMaxSubArray(int[] arr) {
		int sum = 0;
		int maxSum =0;
		int prevNumber=0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++){
			sum = sum+arr[i];
			list.add(arr[i]);
			prevNumber=arr[i];
			if(sum<0){
				sum=0;
				list.clear();
			}
			if(sum>maxSum){
				maxSum = sum;
			}
			
		}
		System.out.println(maxSum);
		Integer[] intArray = new Integer[0];
		return list.toArray(intArray);
	}

}
