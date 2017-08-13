package hacker.warmup;


import java.util.Arrays;

import java.util.Scanner;

public class AngryChildren {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
	   		
		int totalNumbers = in.nextInt();
		
		int windowSize = in.nextInt();
		
		int[] allNumbers = new int[totalNumbers];
		
		for(int i=0;i<totalNumbers;i++)
		{
			allNumbers[i]=in.nextInt();
		}
		
		Arrays.sort(allNumbers);
		
		int minIndex=0;
		int maxIndex=windowSize-1;
		int min=allNumbers[0];
		int max=allNumbers[windowSize-1];
		int minDiff=max-min;
		
		for(int i=1,j=maxIndex+1;j<totalNumbers;i++,j++)
		{
			if(minDiff>allNumbers[j]-allNumbers[i]){
				minIndex=i;
				maxIndex=j;
				min=allNumbers[i];
				max=allNumbers[j];
				minDiff=max-min;
			}
		}
		
		
		System.out.println(minDiff);
		
		
	}

}
