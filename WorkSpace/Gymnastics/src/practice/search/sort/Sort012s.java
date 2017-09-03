package practice.search.sort;

public class Sort012s {
	
	public static void main(String[] args) {
		
		int arr[] = {0,1,2,0,1,2,0,1,0,2,1,0,2,0,1,2,0,0,2,0,0,0,0,2,1,1,
				1,1,2,0,0,0,0,0,1,1,2,2,2,2,2,2,2,2,2,0,0,0,2,0,0,0,0,2,0,
				0,1,1,1,1,0,0,0,2,2,2,0};
		
		sort(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
			
		
	}

	private static void sort(int[] arr) {
		int low =0;
		int high = arr.length-1;
		int mid = low + 1;
		
		while(low<mid && mid<high){
			if(arr[low] == 0) low++;
			if(arr[mid]==1) mid++;
			if(arr[high]==2) high--;
			
			if(arr[low]==1 && arr[mid]==0){
				swap(arr,low,mid);
			}
			if(arr[low]==2 && arr[high]==0){
				swap(arr,low,high);
			}
			if(arr[mid]==2 && arr[high]==1){
				swap(arr,mid,high);
			}
			if(arr[mid]==2 && arr[high]==0){
				swap(arr,mid,high);
			}
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
