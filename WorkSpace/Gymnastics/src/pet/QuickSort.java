package pet;

public class QuickSort {
	public static void main(String[] args) {
		
		int[] arr = {3, 5, 7, 14, 89, 4, 56, 67, 34, 24, 17, 9 , 23};

		for(int i: arr)
		{
			System.out.print(i+" ");
		}
		
		sort(arr);
		System.out.println();
		for(int i: arr)
		{
			System.out.print(i+" ");
		}
		
	
	
	}

	private static void sort(int[] arr) {
		quickSort(arr,0,arr.length-1);
		
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pivot = partition2(arr,low,high);
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
		}
		
		
	}

	private static int partition(int[] arr, int low, int high) {

		int lo = low;
		int hi = high;
		int pivot = low;
		int pivotItem = arr[pivot];
		while(lo<hi) {
			while(lo <= hi && arr[lo]<=pivotItem) {
				lo++;
			}
			while(lo <= hi && arr[hi]>pivotItem) {
				hi--;
			}
			if(lo<hi) {
				swap(arr,lo,hi);
			}
		}
		arr[pivot] = arr[hi];
		arr[hi] = pivotItem;
		return hi;
		
	}
	
	private static int partition2(int[] arr, int low, int high) {

		int lo = low;
		int hi = high;
		int pivot = low + (high-low)/2;
		int pivotItem = arr[pivot];
		while(lo<hi) {
			while(lo <= hi && arr[lo]<=pivotItem) {
				lo++;
			}
			while(lo <= hi && arr[hi]>pivotItem) {
				hi--;
			}
			if(lo<hi) {
				swap(arr,lo,hi);
			}
		}
		arr[pivot] = arr[hi];
		arr[hi] = pivotItem;
		return hi;
		
	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
