package pet;

public class InsertionSort {
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
	
		for(int d = 2;d<=arr.length;d++) {
			int v = arr[d-1];
			int j = d-1;
			while(j>0 && v<arr[j-1]) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = v; 
			
			}
			
	}
	
	
	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
