package pet;

import java.util.ArrayList;
import java.util.List;

public class GreatestSubarraySum {
	public static void main(String[] args) {
		int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
		
		System.out.println(findGreatestSum(arr));
	}

	private static int findGreatestSum(int[] arr) {
		int accumulatedSum = 0;
		int currentNumber = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			currentNumber = arr[i];
			accumulatedSum = accumulatedSum+currentNumber;
			list.add(currentNumber);
			if(accumulatedSum<currentNumber) {
				accumulatedSum = currentNumber;
				list.clear();
				list.add(currentNumber);
				
			}
		}
		System.out.println(list);
		return accumulatedSum;
	}
}
