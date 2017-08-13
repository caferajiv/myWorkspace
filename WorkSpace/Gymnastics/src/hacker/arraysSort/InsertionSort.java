package hacker.arraysSort;

import java.util.Scanner;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
   		
		int arrayLength = in.nextInt();
		int[] array = new int[arrayLength];
		
		for(int i=0;i<arrayLength;i++)
		{
			array[i]=in.nextInt();
		}
		 insertionSortShifts(array);
		
		
	}
	
	private static void insertionSortShifts(int[] array) {
		
		for(int i=1;i<array.length;i++){
			int v=array[i];
			int j=i;
			boolean flag=false;
			while(j>=1 && v<array[j-1]){
				
				array[j]=array[j-1];
				flag = true;
				
			j--;
			
		}
		array[j]=v;
		for(int n:array)
			System.out.print(n+" ");
				
				System.out.println();
		}
			
			
	}

}
