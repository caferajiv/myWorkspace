package hacker.arraysSort;

import java.util.Scanner;

public class Median {
	public static void main(String[] args) {

		
		
		Scanner in = new Scanner(System.in);
   		
		int arrayLength = in.nextInt();
		int[] array = new int[arrayLength];
		
		for(int i=0;i<arrayLength;i++)
		{
			array[i]=in.nextInt();
		}
		int low=0;int high= array.length-1;
		int med = partition(array,low,high);
		
		 /*for(int n:array)
				System.out.print(n+" ");
					
					System.out.println();*/
		
		System.out.println(array[med-1]);
	
	}
	
	private static int partition(int[] array,int low, int high) {

		int pivot = (high+low)/2;
		int pivotItem = array[pivot];
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
		array[pivot]=array[high];
		array[high]=pivotItem;
		
		/*for(int n:array)
			System.out.print(n+" ");
				
				System.out.println();*/
		return high;
	}
	
	private static void swap(int[] array, int low, int high) {
		int temp=array[low];
		array[low]=array[high];
		array[high]=temp;
		
	}


}
