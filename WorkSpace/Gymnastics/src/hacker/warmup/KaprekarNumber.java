package hacker.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaprekarNumber {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		long p = in.nextLong();
		long q = in.nextLong();
		List<Long> list = new ArrayList<Long>();
		if(p>0 && q>0)
		for(;p<=q;p++){
			long num = printKaprekarNumber(p);
			if(num !=-1){
				list.add(num);
			}
		}
		if(list.size()!=0) {
			for(long l: list){
				System.out.print(l+ " ");
			}
		}else {
			System.out.println("INVALID RANGE");
		}
		
	}

	private static long printKaprekarNumber(long p) {
		long square = p*p;
		long digits = calculateDigits(p);
		long number2 = findSecondHalf(square,digits);
		if(number2==0) return -1;
		long number1 = findFirstHalf(square,number2,digits);
		long sum = number1 + number2;
		if(sum == p){
			return p;
		}
		return -1;
	}

	private static long findFirstHalf(long square, long number2, long digits) {
		//int digitsInSquare =  calculateDigits(square);
		long div = (long)Math.pow(10, digits);
		 return (square - number2)/div;
	}

	private static long findSecondHalf(long square, long digits) {
		long div = (long)Math.pow(10, digits);
		return square%div;
	}

	private static long calculateDigits(long p) {
		long count = 0;
		while(p>0){
			p = p/10;
			count++;
		}
		return count;
	}

}
