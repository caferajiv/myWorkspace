package pet;

public class KthSmallest {
	
	public static void main(String[] args) {

		int[] input = {4,7,6,3,9,23,17,13,19,1};
		
		int K = 3;
		int low = 0;
		int high = input.length-1;
		int indexToFind = K-1;
		
		System.out.println(findKthSmallest(input, indexToFind, low, high));
		
	
	}

	private static int findKthSmallest(int[] arr, int indexToFind, int low, int high) {
		
		
		if(low==high) return arr[low];
		if(low<high) {
			int pivot = partition(arr,low,high);
			int pivot_Item = arr[pivot];
			if(pivot == indexToFind) return pivot_Item;
			if(pivot < indexToFind) {
				return findKthSmallest(arr, indexToFind, pivot+1, high);
			}else {
				return findKthSmallest(arr, indexToFind, low, pivot);
			}
		}
		return -1;
	}

	private static int partition(int[] arr, int low, int high) {
		int lo = low;
		int hi = high;
		
		int pivot = low + (high-low)/2;
		int pivot_Item = arr[pivot];
		while(lo<hi) {
			while(arr[lo]<arr[pivot] && lo<hi) lo++;
			while(arr[pivot]<arr[hi] && lo<hi) hi--;

			if(lo<hi) {
				swap(arr,lo, hi);
			}
		}

		arr[pivot]= arr[hi];
		arr[hi] = pivot_Item;
		return hi;
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
