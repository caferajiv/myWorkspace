package pet;

public class RotatedArraySearch {
	
	public static void main(String[] args) {
		int arr[] = {3,4,5,1,2};
		int[] rotArr = new int[]{10,11,12,13,14,15,1,2,3,4,5,6,7,8,9};
		int[] rotatedArr = {7,8,9,10,11,12,13,14,15,16,17,1,2,3,4,5,6};
		
		int low =0;
		int high = rotatedArr.length-1;
		int min = findMin(rotatedArr, low, high);
		System.out.println(min);
		
		int index = rotatedSearch(rotatedArr,low, high, 5);
		System.out.println(index);
	}

	
	private static int findMin(int[] arr, int low, int high) {

		int mid = (high-low)/2 + low;

		if(arr[low]<arr[mid] && arr[mid+1] <arr[high]) {
			if(arr[mid]<arr[mid+1]) return low;
			return mid+1;
		}
		else if(arr[low]<arr[mid] && arr[mid+1]>arr[high]) {
			return findMin(arr, mid+1, high);
		}else if(arr[low]>arr[mid] && arr[mid]<arr[high]) {
			return findMin(arr, low, mid);
		}
		return -1;
	}
	
	//10,11,12,13,14,15,1,2,3,4,5,6,7,8,9
	private static int rotatedSearch(int[] arr, int low, int high, int n) {
		int mid = ( high -low )/2 + low;
		if(arr[mid]==n) return mid;
		if(arr[low]<arr[mid]) {
			if(n>arr[low] && n<arr[mid]) {
				return binarySearch(arr, low, mid-1, n);
			}else {
				return rotatedSearch(arr, mid+1, high, n);
			}
		}else if(arr[mid]<arr[high]) {
			if(n>arr[mid] && n<=arr[high]) {
				return binarySearch(arr, mid+1, high, n);
			}else {
				return rotatedSearch(arr, low, mid-1, n);
			}

		}
		
		
		return 0;
	}
	
	
	private static int binarySearch(int[] arr, int low, int high, int n) {
		if (low<=high) {
			int mid = ( high -low )/2 + low;
			if(arr[mid] == n) return mid;

			if(arr[mid]>n) {
				return binarySearch(arr,low, mid-1,n);
			}else {
				return binarySearch(arr, mid+1,high,n);
			}

		}
		return -1;
	}
	

}
