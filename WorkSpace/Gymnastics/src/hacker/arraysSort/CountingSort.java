package hacker.arraysSort;

import java.util.Scanner;

public class CountingSort {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
   		
		int numbers = in.nextInt();
		int[] origArray=new int[numbers];
		String[] strArray = new String[numbers];
		int[] array = new int[100];
		int[] helper = new int[100];
		
		for(int i=0;i<numbers;i++)
		{
			int num=in.nextInt();
			origArray[i]=num;
			strArray[i]=in.next();
			array[num]++;
		}
		for(int i=0;i<numbers/2;i++)
		{
			strArray[i]="-";
		}
		
		helper[0]=array[0];
		for(int i=1;i<array.length;i++)
		{
			/*for(int j=0;j<array[i];j++)
			{
				System.out.print(i+" ");
			}*/
			
			helper[i]=helper[i-1]+array[i];
		}
		
		for(int n:helper){
			System.out.print(n+" ");
		}
	}

}
