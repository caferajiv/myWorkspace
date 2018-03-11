package pet;

public class BubbleSort {
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

		for(int pass=arr.length-1;pass>0;pass--) {
			for(int j=0;j<pass;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
