package hacker.warmup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsFibo {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
   		
		int noOfTestCases = in.nextInt();
		
		List<BigInteger> fibList= new ArrayList<BigInteger>();
		
		precomputeFibSeries(fibList);
		
		
		BigInteger[] numArray = new  BigInteger[noOfTestCases];
		
		for(int i=0;i<noOfTestCases;i++)
		{
			numArray[i] = new BigInteger(in.next());
			
		}
		
		for(int i=0;i<noOfTestCases;i++)
		{	
			isFibo(numArray[i],fibList);
		}
		
	}

	private static void precomputeFibSeries(List<BigInteger> fibList) {
		fibList.add(0, BigInteger.valueOf(1));
		fibList.add(1,BigInteger.valueOf(1));
		
		for(int i=2;i<100;i++){
			BigInteger fib = fibList.get(i-1).add(fibList.get(i-2));
			BigInteger limit = new BigInteger("10000000000");
			if(limit.compareTo(fib)>0){
				fibList.add(i, fib);
			}else
			{
				break;
			}
			
		}
		
	}

	private static void isFibo(BigInteger n, List<BigInteger> fibList) {
		
		if(fibList.contains(n)){
			System.out.println("IsFibo");
		}else{
			System.out.println("IsNotFibo");
		}
		
	}

}
