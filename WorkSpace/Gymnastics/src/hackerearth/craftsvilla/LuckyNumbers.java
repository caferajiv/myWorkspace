package hackerearth.craftsvilla;

import java.math.BigInteger;
import java.util.Scanner;

public class LuckyNumbers {
	/**
	 * Golu wants to find out the sum of Lucky numbers.Lucky numbers are those numbers 
	 * which contain exactly two set bits.This task is very diffcult for him.
	 * So Help Golu to find sum of those numbers which exactly contain two set bits upto a given number N.
		3 5 10 are lucky numbers where 7 14 are not.
	 * 
	 * @param args
	 */
	
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
   		
		int noOfTestCases = in.nextInt();
		BigInteger[] arr = new BigInteger[noOfTestCases];
		for(int i=0;i<noOfTestCases;i++){
			String line = in.next();
			arr[i] = new BigInteger(line);
			
		}
		
		findLuckyNumberSum(arr);
		
		
		
	}

	private static void findLuckyNumberSum(BigInteger[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++){
			BigInteger sum= new BigInteger("0");
			BigInteger index = new BigInteger("3");
			//for()
			
		}
		
	}

	private static void findLuckyNumberSum(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++){
			int sum=0;
			
			for(int j=3;j<=arr[i];j++){
				String bits=Integer.toBinaryString(j);
				int bitLength = bits.length();
				bits = bits.replaceAll("1","");
				int newBitslength = bits.length();
				if(bitLength-newBitslength==2){
					sum = sum +j;
				}
			}
			
			System.out.println(sum);
			
			
		}
		
	}
	
	private static void findLuckyNumberSum(long[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++){
			long sum=0;
			
			for(long j=3;j<=arr[i];j++){
				String bits=Long.toBinaryString(j);
				int bitLength = bits.length();
				bits = bits.replaceAll("1","");
				int newBitslength = bits.length();
				if(bitLength-newBitslength==2){
					sum = sum +j;
				}
			}
			
			System.out.println(sum);
			
			
		}
		
	}

}
