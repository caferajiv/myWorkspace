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
		
		while(mid<=high){
			if(arr[mid] == 0) {
				swap(arr,low,mid);
				low++;
			}
			else if(arr[mid]==1) mid++;
			
			else if(arr[mid]==2) {
				swap(arr,mid,high);
				high--;
				}
			
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
