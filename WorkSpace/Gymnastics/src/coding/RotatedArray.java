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
		int low=0;
		int high=rotArr.length-1;
		System.out.println(findIndex(rotArr, 13, low, high));
	}
	
	public static int findIndex(int arr[], int a, int low, int high){
		if (low>high) return -1;
		int mid = low+(high-low)/2;
		if(arr[mid]==a)return mid;
		if(arr[mid]>arr[low]){
			if(arr[low]<a && arr[mid]>a)
			return BinarySearch.search(arr, a, low, mid-1);
			else return findIndex(arr, a, mid
					+1, high);
			
		}
		else if(arr[mid]<arr[high])
		{
			if(a>arr[mid] && a < arr[high])
			return BinarySearch.search(arr, a, mid+1, high);
			else return findIndex(arr, a, low, mid-1);
		}
		return -1;
		
	}
	
	

}
