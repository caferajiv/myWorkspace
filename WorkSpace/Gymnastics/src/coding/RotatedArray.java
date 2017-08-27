package coding;

import search.BinarySearch;
import sort.BubbleSort;

/*
 * Question: When some elements at the beginning of an array are 
 * moved to the end, it gets a rotation of the original array. 
 * Please implement a function to search a number in a rotation 
 * of an increasingly sorted array. Assume there are no duplicated 
 * numbers in the array.
 */
public class RotatedArray {
	
	public static void main(String[] args) {
		int[] rotArr = new int[]{10,11,12,13,14,15,1,2,3,4,5,6,7,8,9};
		int[] rotatedArr = {7,8,9,10,11,12,13,14,15,16,17,1,2,3,4,5,6};
		int low=0;
		int high=rotatedArr.length-1;
		System.out.println(findIndex(rotatedArr, 16, low, high));
	}
	
	public static int findIndex(int arr[], int a, int low, int high){
		if (low>high) return -1;
		int mid = low+(high-low)/2;
		if(arr[mid]==a)return mid;
		if(arr[mid]>arr[low]){
			if(arr[low]<a && arr[mid]>a)
			return binarySearch(arr, a, low, mid-1);
			else return findIndex(arr, a, mid
					+1, high);
			
		}
		else if(arr[mid]<arr[high])
		{
			if(a>arr[mid] && a < arr[high])
			return binarySearch(arr, a, mid+1, high);
			else return findIndex(arr, a, low, mid-1);
		}
		return -1;
		
	}
	
	private static int binarySearch(int[] arr, int num, int low, int high) {

		if(num<arr[low] || num>arr[high])return -1;
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(arr[mid]==num) return mid;
		if(num<arr[mid])
			return binarySearch(arr, num, low, mid-1);
		else
			return binarySearch(arr, num, mid+1, high);
		
	}
	
	

}
