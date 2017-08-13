package hacker.warmup;

import java.util.Scanner;

public class GemStone {
	
public static void main(String[] args) {

	 Scanner in = new Scanner(System.in);
       int noOfTestCases=0;
       noOfTestCases=in.nextInt();
       
       String[] strArray = new String[noOfTestCases];
       for(int i=0;i<noOfTestCases;i++)
       {
       	 strArray[i]=in.next();
       	
       }
       
       int[] arrOfChars = new int[130];
       for(int i=0;i<noOfTestCases;i++)
       {
       	 for(int j=0;j<strArray[i].length();j++)
       	 {
       		 if(arrOfChars[strArray[i].charAt(j)]==i){
       			arrOfChars[strArray[i].charAt(j)]=i+1;
       		 }
       	 }
       }
       int totalGemStones=0;
       for(int i=0;i<arrOfChars.length;i++)
       {
    	   if(arrOfChars[i]==noOfTestCases)
    	   {
    		   totalGemStones = totalGemStones+1;   
    	   }
    	   
       }
	
	System.out.println(totalGemStones);
	
	

}

}
