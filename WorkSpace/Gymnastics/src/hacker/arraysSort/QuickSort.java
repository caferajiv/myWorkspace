package hacker.arraysSort;

import java.util.Scanner;

public class QuickSort {
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
   		
		int arrayLength = in.nextInt();
		int[] array = new int[arrayLength];
		
		for(int i=0;i<arrayLength;i++)
		{
			array[i]=in.nextInt();
		}
		int low=0;int high= array.length-1;
		quickSort(array,low,high);
		
		 /*for(int n:array)
				System.out.print(n+" ");
					
					System.out.println();*/
	}

	private static void quickSort(int[] array, int low, int high) {
		
		int pivot;
		if(high>low){
			pivot=partition(array,low,high); 
			quickSort(array,low,pivot-1);
			quickSort(array,pivot+1,high);
			
		}
		
	}

	private static int partition(int[] array,int low, int high) {

		int pivot = low;
		int pivotItem = array[low];
		int left = low;
		int right = high;

		while (low < high) {

			while (low <= high && array[low] <= pivotItem)
				low++;
			while (low <= high && array[high] > pivotItem)
				high--;

			if (low < high) {
				swap(array, low, high);
			}
		}
		array[left]=array[high];
		array[high]=pivotItem;
		
		for(int n:array)
			System.out.print(n+" ");
				
				System.out.println();
		return high;
	}

	private static void swap(int[] array, int low, int high) {
		int temp=array[low];
		array[low]=array[high];
		array[high]=temp;
		
	}

}
