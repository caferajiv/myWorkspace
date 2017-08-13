package hacker.warmup;


import java.util.Scanner;

public class FindDigit {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
   		
		int noOfTestCases = in.nextInt();
		
		int[] numArray = new  int[noOfTestCases];
		
		for(int i=0;i<noOfTestCases;i++)
		{
			numArray[i] = in.nextInt();
			
		}
		
		for(int i=0;i<noOfTestCases;i++)
		{
			printPositions(numArray[i]);
			
		}
		
		
	}

	private static void printPositions(int num) {
		
		int temp = num;
		int count=0;
		while(temp!=0){
			
		 int digit =	temp%10;
		 temp =	temp/10;
		 if(digit==0) continue;
		 if(num%digit==0){
			 count++;
		 }
			
		
		}
		
		System.out.println(count);
	}

}
