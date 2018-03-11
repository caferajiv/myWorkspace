package pet;

public class SelectionSort {
	public static void main(String[] args) {

		
		int[] arr = {3, 5, 7, 14, 89, 4, 56, 67, 34, 24, 17, 9 , 23};

		for(int i: arr)
		{
			System.out.print(i+" ");
		}
		
		sort(arr);
		System.out.println();
		for(int i: arr)
		{
			System.out.print(i+" ");
		}
		
	
	}

	private static void sort(int[] arr) {

		for(int i=0;i<arr.length-1;i++) {
			int min = i;
			for(int j = i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) min = j;
			}
			swap(arr,min,i);
		}
	}

	private static void swap(int[] arr, int min, int i) {
		int temp = arr[i];
		arr[i]=arr[min];
		arr[min]= temp;
	}

}
