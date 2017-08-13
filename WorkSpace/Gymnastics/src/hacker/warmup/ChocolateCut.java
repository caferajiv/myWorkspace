package hacker.warmup;

import java.math.BigInteger;
import java.util.Scanner;

public class ChocolateCut {
	
	public static void main(String[] args) {
		
			
		Scanner in = new Scanner(System.in);
        
		int noOfTestCases = Integer.parseInt(in.nextLine());
		
		BigInteger [] arr = new BigInteger[noOfTestCases];
		
		for(int i=0;i<noOfTestCases;i++)
		{
			arr[i]=new BigInteger(in.nextLine());
		}
		
		for(int i=0;i<noOfTestCases;i++)
		{
			System.out.println(getChocoloatePieces(arr[i]));
		}
		
	}

	private static BigInteger getChocoloatePieces(BigInteger k) {
		
		BigInteger half = k.divide(new BigInteger("2"));
		BigInteger other_half = k.subtract(half);
		
		
		return half.multiply(other_half);
	}

}
