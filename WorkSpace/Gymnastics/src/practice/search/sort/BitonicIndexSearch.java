package practice.search.sort;

public class BitonicIndexSearch {

	public static void main(String[] args) {

		int[] arr = { 1, 6, 9, 23, 56, 78, 90, 45, 24, 8 };

		// and 6
		int low = 0;
		int high = arr.length - 1;
		System.out.println(findBitonicIndex(arr, low, high));

	}

	private static int findBitonicIndex(int[] arr, int low, int high) {
		int index = -1;
		int mid = ((high - low) / 2) + low;

		if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
			return findBitonicIndex(arr, mid, high);
		} else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
			return findBitonicIndex(arr, low, mid);
		} else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
			return mid;
		}

		return index;
	}

}
