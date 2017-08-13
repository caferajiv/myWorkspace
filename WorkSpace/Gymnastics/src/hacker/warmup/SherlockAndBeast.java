package hacker.warmup;

import java.util.Scanner;

public class SherlockAndBeast {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	    
		int noOfTestCases = in.nextInt();
		
		int[] arr = new int[noOfTestCases];
		
		for(int i=0;i<noOfTestCases;i++)
		{
			arr[i]=in.nextInt();
		}
		
		for(int i=0;i<noOfTestCases;i++)
		{
			findDecentNumber(arr[i]);
		}
	}

	private static void findDecentNumber(int digit) {
		StringBuilder sb=new StringBuilder("");
		
		for(int i=digit;i>=0;i--){
			if(i%3==0 && (digit-i)%5==0)
			{
				for(int k=0;k<i;k++)
				{
					sb.append("5");
					//System.out.print(5);
				}
				for(int k=0;k<digit-i;k++)
				{
					sb.append("3");
					//System.out.print(3);
				}
				break;
			}
		}
		
		if(sb.toString().equals("")){
			System.out.println("-1");
		}else
		{
			System.out.println(sb.toString());
		}
	}
		

}
