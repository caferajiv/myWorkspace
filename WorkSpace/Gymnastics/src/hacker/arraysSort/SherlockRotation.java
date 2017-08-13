package hacker.arraysSort;

import java.util.Scanner;

public class SherlockRotation {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
   		
		int arraylenth = in.nextInt();
		int[] array = new int[arraylenth];
		int[] helperArray = new int[arraylenth];
		int rotations = in.nextInt();
		int queries = in.nextInt();
		int[] query = new int[queries];
		for(int i=0;i<arraylenth;i++){
			array[i]=in.nextInt();
		}
		
		for(int i=0;i<queries;i++){
			query[i]=in.nextInt();
		}
		
		for(int i=0;i<rotations;i++)
		{
			for(int j=0;j<arraylenth;j++){
				int rot = i-(arraylenth-1);
				if(rot<0){
					rot=arraylenth+rot;
				}
				
				helperArray[rot]=array[j];
			}
			
			System.arraycopy(helperArray, 0, array, 0, helperArray.length);
		}
		
		
		for(int i=0;i<query.length;i++)
		{
			System.out.println(array[query[i]]);
		}
		
	}

	private static void swap(int[] array, int rot, int j) {
		// TODO Auto-generated method stub
		
		int temp= array[j];
		array[j]=array[rot];
		array[rot]= temp;
		
	}

}
