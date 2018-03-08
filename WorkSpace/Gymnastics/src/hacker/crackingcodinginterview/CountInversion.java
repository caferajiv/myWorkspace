package hacker.crackingcodinginterview;

import java.util.Scanner;

public class CountInversion {

	static long count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int length = sc.nextInt();
			int[] arr = new int[length];
			for(int j=0;j<length;j++) {
				arr[j] = sc.nextInt();
			}
			count=0;
			countInversion(arr);
			//sort(arr);
			System.out.println(count);
		} 
		
	}
	
	public static int[] sort(int[] a){
		int n= a.length;
		int indexVal=0;
		int j=0;
		for (int i=1;i<n; i++)
		{ //indexVal = a[i];
			for (j=i;j>0;j--)
			{
				if(j>=1 && a[j]<a[j-1] )
				{//a[j-1]=a[j];
				swap(a, j-1, j);	
				}
			}
			//a[j]=indexVal;
		}
		return a;
	}
	
	private static void swap(int []arr, int i , int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
		count++;
	}

	private static void countInversion(int[] arr) {
		
		int low =0;
		int high = arr.length-1;
		int[] temp = new int[arr.length];
		count=0;
		mergeSort(low,high,arr,temp);
	}


	private static void mergeSort(int low, int high, int[] arr, int[] temp) {

		if(low<high) {
			int mid = low + (high-low)/2;
			mergeSort(low, mid,arr,temp);
			mergeSort(mid+1, high, arr, temp);
			merge(low,mid+1,high,arr,temp);
			
		}
		
	}
	
	private static void merge(int low, int mid, int high, int[] arr, int[] temp) {
		int lo = low;
		int lo_end = mid-1;
		int mi = mid;
		int size = high -low +1;
		int i=low;
		while(lo<=lo_end && mi<=high) {
		
			if(arr[lo]<=arr[mi]) {
				temp[i++] = arr[lo];
				lo++; //count++;
			}else {
				temp[i++] = arr[mi];
				mi++; 
				count += mid - lo;
			}
			
		}
		//count=count+lo_end-lo;
		
		while(lo<=lo_end) {
			temp[i] = arr[lo];
			i++;
			lo++;
			
			
			
		}
		while(mi<=high) {
			temp[i] = arr[mi];
			i++;
			mi++;
			
		}
		
		for(int j=0;j<size;j++) {
			arr[high] = temp[high];
			high--;
		}
		
	
	
	}

}
