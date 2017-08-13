package pet;

public class RotatedArray {
	
	public static void main(String[] args) {
		
		int arr[] = {3,4,5,1,2};
		int min = findMin(arr);
		System.out.println(min);
		
	}

	private static int findMin(int[] arr) {
		
		int low = 0;
		int high = arr.length;
		
		return findMinimum(arr,low,high-1);
		
	}

	private static int findMinimum(int[] arr, int low, int high) {
		if(low==high)
			return arr[low];
		if(low>high)
			return -1;
		if(low<high){
			int mid = ((low+high)-low)/2;
			if(arr[low]<arr[mid]){
				if(arr[mid]<arr[mid+1]){
					return findMinimum(arr, mid+1, high);
				}else{
					return arr[mid+1];
				}
			}else {
				if(arr[mid]<arr[mid-1]){
					return arr[mid];
				}else{
					return findMinimum(arr, low, mid-1);
				}
			}
			
		}
		return -1;
		
	}

}
