package coderust.misc;

import java.util.Arrays;

public class SumOf3Numbers {
	
	public static void main(String[] args) {
		
		int sum = 20;
		int[] arr = {3,7,1,2,8,4,5};
		
		System.out.println(find_sum_of_three(arr,sum));
	}
	
	public static boolean find_sum_of_three(int arr[], int sum) {

		Arrays.sort(arr);
		
		for(int k=0;k<arr.length;k++) {
			int new_sum = sum - arr[k]; 
			for(int i=0,j=arr.length-1;i<j;) {
				if(i==k) {i++; continue;}
				if(j==k) {j--; continue;}
				
				int current_sum = arr[i] + arr[j];
				if(current_sum == new_sum) return true;
				
				if(current_sum<new_sum) {
					i++;
				}else {
					j--;
				}
				
			}
		
		}

		return false;
	}

}
