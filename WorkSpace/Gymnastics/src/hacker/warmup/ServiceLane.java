package hacker.warmup;

import java.util.Scanner;

public class ServiceLane {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	       int len_1d_arr = in.nextInt();
	       int len_2d_arr = in.nextInt();
	       
	       
	       int[] d1Arr = new int[len_1d_arr];
	       int[][] d2Arr = new int[len_2d_arr][2];
	       
	       for(int i=0;i<len_1d_arr;i++)
	       {
	    	   d1Arr[i]=in.nextInt();
	       }
	       
	       for(int i=0;i<len_2d_arr;i++)
	       {
	    	   for(int j=0;j<2;j++)
		       {
	    		   d2Arr[i][j]=in.nextInt();
		       }
	       }
	       
	       
	       
	       for(int i=0;i<len_2d_arr;i++)
	       {
	    	   int min=Integer.MAX_VALUE;
	    	   int window_start=d2Arr[i][0];
	    	   int window_end=d2Arr[i][1];
	    	   
	    	   for(int j=window_start;j<=window_end;j++)
	    	   {
	    		   if (d1Arr[j]<min){
	    			   min=d1Arr[j];
	    		   }
	    	   }
	    	   System.out.println(min);
	    	   
	       }
	}

}
