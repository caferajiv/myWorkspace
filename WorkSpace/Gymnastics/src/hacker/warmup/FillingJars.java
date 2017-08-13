package hacker.warmup;

import java.math.BigInteger;
import java.util.Scanner;

public class FillingJars {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    
		BigInteger noOfJars = BigInteger.valueOf(in.nextInt());
		
		int noOfCases = in.nextInt();
		
		BigInteger sum=new BigInteger("0");
		
		for(int m=0;m<noOfCases;m++)
		{
			
			BigInteger i= BigInteger.valueOf(in.nextInt());
			BigInteger j= BigInteger.valueOf(in.nextInt());
			
			BigInteger diff = (j.subtract(i)).add(BigInteger.valueOf(1));
			
			BigInteger add= BigInteger.valueOf(in.nextInt());
			
			sum=sum.add(add.multiply(diff));
			
			
		}
		
		BigInteger avg=sum.divide(noOfJars);
		System.out.println(avg);
		
	}

}
