package hacker.warmup;

import java.util.Scanner;

public class Loveletter {
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int noOfTestCases=0;
	        noOfTestCases=in.nextInt();
	        
	        String[] strArray = new String[noOfTestCases];
	        for(int i=0;i<noOfTestCases;i++)
	        {
	        	 strArray[i]=in.next();
	        	
	        }
	        
	        for(int i=0;i<noOfTestCases;i++)
	        {
	        	System.out.println(stepsToPalindrome(strArray[i]));
	        }
		
		
		
		
	}

	private static int stepsToPalindrome(String s) {
		 
		if(s==null || s.length()<=1)
			return 0;
		int strLength = s.length();
		
		int sum=0;
		for(int i=0,j=strLength-1;j>i;i++,j--)
		{
			int diff = calculateDifference(s.charAt(i),s.charAt(j));
			
			sum=sum+diff;
		}
		return sum;
	}

	private static int calculateDifference(char first, char second) {
		if(second>first){
			return second-first;
		}
		return first-second;
	}

}
