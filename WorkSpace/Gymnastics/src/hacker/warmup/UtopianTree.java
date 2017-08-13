package hacker.warmup;

import java.util.Scanner;

public class UtopianTree {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int noOfTestCases=0;
	        noOfTestCases=in.nextInt();
	        int[] growthCycles = new int[noOfTestCases];
	        for(int i=0;i<growthCycles.length;i++)
	         {
	         growthCycles[i]=in.nextInt();
	         }
	     
	        for(int i=0;i<growthCycles.length;i++)
	         {
	          int height;
	        height = getUtopianTreeHeight(growthCycles[i]);
	        System.out.println(height);
	         }
		 
		
	       
	   }

	private static int getUtopianTreeHeight(int growthCycle) {

		int height=0;
		if(growthCycle==0)
			return height;
		if(growthCycle==1)
			return 2;

		if(growthCycle%2==0)
		{
			return getEvenGrowthCycleHeight(growthCycle);
		}else
		{
			return 2*(getEvenGrowthCycleHeight(growthCycle-1));
		}
		
	}

	private static int getEvenGrowthCycleHeight(int growthCycle) {
		
		int power =  growthCycle/2;
		int num = 1<<power;
		
		return 2*(num-1)+1;
		 
	}

}
