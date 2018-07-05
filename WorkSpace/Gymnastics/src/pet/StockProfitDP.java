package pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StockProfitDP {
	
	public static void main(String[] args) {
		
		int[] arr = {100, 180, 260, 310, 40, 535, 695};
		
		//int[] arr = {5, 5, 5, 5, 5};
		
		//int[] arr = {10, 1, 9, 2, 8, 3, 7};
		
		//int[] arr = {21,12,11,9,6,3};
		
		//int[] arr = {1, 2, 3, 4, 3, 2, 1, 2, 5};
		
				//int[] arr = {12,5,9,19,8};
				
		
		
		System.out.println(max_ProfitDP_WithoutLocalMinima(arr));
	}

	private static int max_ProfitDP_WithoutLocalMinima(int[] arr) {
		
		int current_buy = arr[0];
		int current_sell = arr[1];
		
		int total_profit = 0;
		int max_profit = current_sell - current_buy;
		
		int current_profit = Integer.MIN_VALUE;
		
		for(int i=1;i<arr.length;i++)
		{
			current_profit = arr[i]-current_buy;
			if(current_profit  > max_profit) {
				max_profit = current_profit;
			}
			
			if(current_buy>arr[i]) {
				current_buy = arr[i];
				
				total_profit = total_profit + max_profit;
				max_profit = 0;
			}
		}
		
		return total_profit+max_profit;
	}

	private static int max_Profit(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		List<Integer>  localMinimas = new ArrayList<>();
		localMinimas = findLocalMinimas(arr,low,high,localMinimas); 
		
		int max_profit = 0;
		if(localMinimas.size()==1) {
			max_profit = max_profit + Math.abs(arr[localMinimas.get(0)] - arr[arr.length-1]);
			return max_profit;
		}
		Collections.sort(localMinimas);
		for (int i=0;i<localMinimas.size();i++) {
			if(i==localMinimas.size()-1) {
				max_profit = max_profit + Math.abs(arr[localMinimas.get(i)] - arr[arr.length-1]);
			}else {
				max_profit = max_profit + Math.abs(arr[localMinimas.get(i)] - arr[localMinimas.get(i+1)-1]);
			}
			
		}
		
		return max_profit;
	}

	private static List<Integer> findLocalMinimas(int[] arr, int low, int high,List<Integer>  localMinimas) {
		
		if(low<high) {
			if(high-low==1 && low==0 && arr[high]>=arr[low]) {
				localMinimas.add(low);
				return localMinimas;
			}

			int mid = low + (high-low)/2;
			if(mid == 0) {
				return localMinimas;
			}
			if(arr[mid-1]>arr[mid] && arr[mid+1]>arr[mid]) {
				localMinimas.add(mid);
			} 
			findLocalMinimas(arr, low, mid, localMinimas);
			findLocalMinimas(arr, mid+1, high, localMinimas);
		}
		
		
		return localMinimas;
	}

}
