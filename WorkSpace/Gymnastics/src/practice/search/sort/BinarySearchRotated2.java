package practice.search.sort;

public class BinarySearchRotated2 {
	public static void main(String[] args) {
		
		int[] rotatedArr = {7,8,9,10,11,12,13,14,15,16,17,1,2,3,4,5,6};
		int low = 0;
		int searchVal = 16;
		int high = rotatedArr.length-1;
		
		System.out.println(binarySearchRotated(rotatedArr, low, high, searchVal));
		
		
	}

	private static int binarySearchRotated(int[] arr, int low, int high, int data) {
	
		if(low<high) {
			int mid = low+(high-low)/2;
			if (arr[mid] == data)
				return mid;
			if(arr[mid]>arr[low] && arr[mid]>arr[high]) {
				if(data<arr[mid] && data > arr[low]) {
					return binarySearch(arr, low, mid-1, data);
				}else {
					return binarySearchRotated(arr, mid, high, data);
				}
			}else if(arr[mid]<arr[low] && arr[mid]<arr[high]) {
				if(data > arr[mid] && data < arr[high]) {
					return binarySearch(arr, mid+1, high, data);
				}else {
					return binarySearchRotated(arr, low , mid, data);
				}
				
			}
		}
		
		return -1;
	}
	
	private static int binarySearch(int[] arr, int low, int high, int val) {
		if(val<arr[low] || val>arr[high]) return -1;
		if (low > high)
			return -1;

		int mid = (low+high)/2;
		if (arr[mid] == val)
			return mid;
		if (val < arr[mid]) {
			return binarySearch(arr, low, mid - 1, val);
		} else {
			return binarySearch(arr, mid+1, high, val);
		}

	}

}
