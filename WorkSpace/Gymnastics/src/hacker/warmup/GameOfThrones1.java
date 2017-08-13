package hacker.warmup;

import java.util.Scanner;

public class GameOfThrones1 {
	
	public static void main(String[] args) {
	       Scanner in = new Scanner(System.in);
	       String str = in.next();
	       
	       int strLent= str.length();
	        int[] arr = new int[26];
	        for(int i=0;i<strLent;i++)
	        {
	        	 ++arr[str.charAt(i)-'a'];
	        }
	        int sum=0;
	       for(int i=0;i<26;i++)
	       {
	    	   sum=sum+(arr[i]%2);
	       }
	       
	       if(sum>1){
	    	   System.out.println("NO");
	       }else
	       {
	    	   System.out.println("YES");
	       }
	        
	in.close();
	}

}
