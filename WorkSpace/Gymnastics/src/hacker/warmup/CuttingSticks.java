package hacker.warmup;

import java.util.Scanner;

public class CuttingSticks {
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	       int noOfTestCases=0;
	       noOfTestCases=in.nextInt();
	       
	       int[] stickArray = new int[noOfTestCases];
	       for(int i=0;i<noOfTestCases;i++)
	       {
	    	   stickArray[i]=in.nextInt();
	       	
	       }
	       
	       int min=0;
	       int minFrequency=0;
	       int count =0;
	       
	       while(min!=Integer.MAX_VALUE){
	    	   min=Integer.MAX_VALUE;
	    	   count =0;
	    	   for(int i=0;i<noOfTestCases;i++)
	    	   {
	    		   if(stickArray[i]!=0 && stickArray[i]<min)
	    		   {
	    			   min=stickArray[i];
	    			   minFrequency=1;
	    		   }
	    	   }
	    	   
	    	   for(int i=0;i<noOfTestCases;i++)
	    	   {
	    		  if(stickArray[i]!=0){
	    			  count++;
	    			  stickArray[i]=stickArray[i]-min;
	    		  } 
	    	   }
	    	   if(count>0)
	    	   System.out.println(count);
	    	   
	       }
	       
	}

}
