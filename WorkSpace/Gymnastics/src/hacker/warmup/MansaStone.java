package hacker.warmup;

import java.util.Scanner;

public class MansaStone {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
		int noOfTestCases = in.nextInt();
		//System.out.println(noOfTestCases);
		
		int arr[][] = new int[noOfTestCases][3];
		
		
		for(int i=0;i<noOfTestCases;i++)
		{
			arr[i][0]=in.nextInt();
			arr[i][1]=in.nextInt();
			arr[i][2]=in.nextInt();
		}
		
		for(int i=0;i<noOfTestCases;i++)
		{
			findLastStone(arr[i][0],arr[i][1],arr[i][2]);
		}
		
	}

	private static void findLastStone(int noOfStones,int diff1, int diff2) {
		
		int minDiff=diff1;
		int maxDiff=diff2;
		if(diff2<diff1){
			minDiff=diff2;
			maxDiff=diff1;
		}else if(diff1==diff2){
			int last = (noOfStones-1)*minDiff;
			System.out.print(last+" ");
			System.out.println();
			return;
		}
		
		int loop = noOfStones-1;
		for(int i=0;i<=loop;i++)
		{
			int last = i*maxDiff + (loop-i)*minDiff;
			System.out.print(last+" ");
		}
		System.out.println();
	}
	
	
}
