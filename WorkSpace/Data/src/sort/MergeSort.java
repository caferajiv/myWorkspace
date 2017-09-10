package sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] unsortedArray = new int[] { 3, 5, 7, 14, 89, 4, 56, 67, 34, 24,
				17, 9, 23 };
		
		int[] arr = { 130, 3, 235, 36, 78, 0, 11, 125, 10, 144, 19, 78 };
		int[] temp = new int[arr.length]; 
		int low=0;
		int high= arr.length-1;
		mergesort(arr,temp, low, high);
		for (int i : temp) {
			System.out.print(i+" ");
		}
	}

	public static void mergesort(int[] a, int[] temp, int low, int high){
		
        if(low<high)
        {
        	int mid = low+(high-low)/2;
        	mergesort(a, temp, low, mid);
        	mergesort(a, temp, mid+1,high);
        	merge(a, temp, low, mid+1, high);
        }
	}
	
	private static void merge(int[] a, int[] temp, int low, int mid, int high) {
		int low_end= mid-1;
		int i;
		int size=high-low+1;
		int temp_pos=low;
		while(low<=low_end && mid<=high)
		{
			if(a[low]<=a[mid])
			{
				temp[temp_pos++]=a[low];
				low++;
			}
			else{
				temp[temp_pos++]=a[mid];
				mid++;
			}
		}
		while(low<=low_end)
		{
			temp[temp_pos++]=a[low++];
		}
		while(high>=mid)
		{
			temp[temp_pos++]=a[mid++];
		}
		
		for(i=0;i<size;i++){
			a[high]=temp[high];
			high--;
		}
		
	}
	
	


}
