package coderust.arrays;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = {3,2,7,5,9,0};
		System.out.println(bin_search(arr,5));
	}
	
	private static int bin_search(int[] a, int key) {
	    int low = 0;
	    int high = a.length-1;
	    return bin_search(a, low, high, key);
	    
	  }
	  
	 private static int bin_search(int[] arr, int low, int high, int key) {
	    if(key < arr[low] || key >arr[high]) return -1;
	    if(arr[low] == key) return low;
	    if(arr[high] == key) return high;
	    if(low<high){
	      int mid = low + (high-low)/2;
	        if(arr[mid] == key) return mid;
	        if(key < arr[mid]){
	          return bin_search(arr, low, mid-1, key);
	        } else {
	          return bin_search(arr,mid+1, high , key);
	      }
	   }
	      
	    return -1;
	  }

}
