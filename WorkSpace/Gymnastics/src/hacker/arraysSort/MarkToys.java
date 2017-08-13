package hacker.arraysSort;

import java.util.Arrays;
import java.util.Scanner;

public class MarkToys {
	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
   		
		int arrayLength = in.nextInt();
		int money = in.nextInt();
		int[] array = new int[arrayLength];
		
		for(int i=0;i<arrayLength;i++)
		{
			array[i]=in.nextInt();
		}
		
		Arrays.sort(array);
		int sum=0;
		int toys=0;
		for(int i=0;i<arrayLength;i++){
			sum=sum+array[i];
			if(sum>=money){
				toys=i;
				break;
				
			}
		}
		
		System.out.println(toys);
		
	}

}
