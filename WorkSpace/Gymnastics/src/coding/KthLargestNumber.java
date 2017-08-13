package coding;

import sort.QuickSort;

public class KthLargestNumber {
	
	public static int elementsBeforePivot=0;
	
	public static void main(String[] args) {
		int[] unsortedArray = new int[]{3, 5, 7, 14, 89, 4, 56, 67, 34, 
				24, 17, 9 , 23};
		int low=0;
		int high= unsortedArray.length-1;
		int kthLargest = findKthLargest(unsortedArray,3,low, high);
		System.out.println(kthLargest);
	}
	
	private static void swap(int []arr, int i , int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
	}

	private static int findKthLargest(int[] arr, int k, int low, int high) {
		int pivot;
		if(low==high) return arr[low];
		if(low<high)
		{
			pivot=QuickSort.partition(arr, low, high);
			if(pivot==arr.length-k) return arr[pivot];
			else if(pivot<arr.length-k){
				return findKthLargest(arr, k, pivot+1, high);
			}
			else if(pivot>arr.length-k)
			{
				return findKthLargest(arr, k, low, pivot-1);
			}
		}
		return -1;
		
	}

}
