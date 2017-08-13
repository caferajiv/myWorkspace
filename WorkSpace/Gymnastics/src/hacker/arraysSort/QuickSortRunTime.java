package hacker.arraysSort;

import java.util.Scanner;

public class QuickSortRunTime {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
   		
		int arrayLength = in.nextInt();
		int[] array = new int[arrayLength];
		
		for(int i=0;i<arrayLength;i++)
		{
			array[i]=in.nextInt();
		}
		int diff = insertionSortShifts(array)-quickSortSwaps(array);
		System.out.println(diff);
		
	}

	private static int quickSortSwaps(int[] array) {
		
		return 0;
	}

	private static int insertionSortShifts(int[] array) {
		int shifts=0;
		for(int i=1;i<array.length;i++){
			int v=array[i];
			int j=i;
			
			while(j>=1 && v<array[j-1]){
				
				array[j]=array[j-1];
				shifts++;
				
			j--;
			
		}
		array[j]=v;
		
		}
			
	return shifts;		
	}
}

