package jbb;

import java.io.IOException;

public class NumberUtility {
	
	public static int noOfDigitsInAnumber(long number)
	{
		int noOfDigits=0;
		while(number%10!=0)
		{
			number=number/10;
			noOfDigits++;
		}
		return noOfDigits;
	}
	
	public static long reverseNumbers(long number)
	{
		int numberOfDigits=noOfDigitsInAnumber(number);
		long reversedNumber=0;
		long currentNumber=0;
		for(int i=0;i<numberOfDigits;i++)
		{
			currentNumber=number%10;
			number=number/10;
			reversedNumber = (reversedNumber*10)+currentNumber;
		}
		return reversedNumber;
	}
	
	public static boolean validateNumber(long number)
	{
		
		long lastTwoDigits=number%100;
		long restOfDigits=number/100;
		if(restOfDigits%97==lastTwoDigits)
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		/*
		System.out.println(noOfDigitsInAnumber(27987786876L));
		System.out.println(27987786876L);
		System.out.println(reverseNumbers(27987786876L));
		
		try {
			System.out.println(Runtime.getRuntime().exec("tasklist"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		int one= 4;
		int two= 2;
		int three=one^two;
		System.out.println(three);

	}
	
	
}
