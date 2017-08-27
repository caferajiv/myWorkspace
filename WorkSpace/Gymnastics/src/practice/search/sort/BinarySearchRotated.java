package practice.search.sort;

public class BinarySearchRotated {

	public static void main(String[] args) {
		
		int[] rotatedArr = {7,8,9,10,11,12,13,14,15,16,17,1,2,3,4,5,6};
		
		// search 11
		//ans = 4
		int low = 0;
		int searchVal = 16;
		int high = rotatedArr.length-1;
		System.out.println("Turning index in rotated array: "+findTurningIndex(rotatedArr,low, high));
		
		System.out.println("Rotated Search Index of 16 : "+searchRotated2(rotatedArr,low,high,searchVal));
		
		System.out.println("Binary Search Index of 16 : "+binarySearch(rotatedArr,0, 10,16));

	}
	private static int findTurningIndex(int[] arr, int low, int high) {
		int index = -1;
		if (low > high)
			return -1;

		int mid = (high - low) / 2 + low;
		if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1])
			return mid;
		if (arr[low] < arr[mid] && arr[mid] > arr[high]) {
			return findTurningIndex(arr, mid + 1, high);

		} else {
			return findTurningIndex(arr, low, mid - 1);
		}
	}
	
	private static int searchRotated2(int[] arr, int low, int high, int val) {
		// turningIndex is the index of smallest number in the rotated array
		// hence turningIndex -1 is the index of the largest number.
		int turningIndex = findTurningIndex(arr, low, high);
		if (turningIndex == -1)
			return -1;
		if (arr[turningIndex] == val)
			return turningIndex;
		if (turningIndex == 0) {
			return binarySearch(arr, low, high, val);
		}
		if (val > arr[low] && val < arr[turningIndex - 1]) {
			return binarySearch(arr, low, turningIndex - 1, val);
		} else {
			return binarySearch(arr, turningIndex + 1, high, val);
		}

	}

	private static int searchRotated(int[] arr, int low, int high, int val) {
		
		if (low > high)
			return -1;
		int mid = low+(high-low)/2;
		if (arr[mid] == val)
			return mid;
		if (arr[mid]>arr[low]) {
			if (val >arr[low] && arr[mid] > val)
				return binarySearch(arr, low, mid-1, val);
			else
				return searchRotated(arr, mid+1, high, val);
		} else if (arr[mid] < arr[high]) {

			if (val > arr[mid] && val< arr[high])
				return binarySearch(arr, mid+1, high, val);
			else
				return searchRotated(arr, low, mid-1, val);
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
