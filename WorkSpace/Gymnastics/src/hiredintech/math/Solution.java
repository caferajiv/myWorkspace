package hiredintech.math;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
	int num = 8;
	int deno = 24;
	int [] result= new int[2];
	System.out.println(prime_counting(2));
    }
    
    
    public static int prime_counting(int n) {
	List<Integer> primeList = new ArrayList<>();

	int curr_num = 2;

	while(curr_num <= n) {

	    if(isPrime(curr_num,primeList))
	    {
		primeList.add(curr_num);
	    }

	    curr_num++;
	}

	//System.out.println(primeList);
	return primeList.size();
    }
    
    private static boolean isPrime(int curr_num, List<Integer> primeList) {
	int sqrt = (int)Math.sqrt(curr_num);
	for(int prime : primeList) {
	    if(prime <= sqrt) {
		if(curr_num%prime == 0) {
		    return false;
		}
	    }else {
		break;
	    }
	}
	return true;
    }


    public static long sum_the_divisors(int number) {
        long sum = 0 ;
        if(number == 1) return 1;
        
        int num = 1;
	double sqrt = Math.sqrt(number);
	while(num<=sqrt) {
	    if(number%num==0) {
		if(num == sqrt) {
		   sum = sum + num;
		}else {
		    sum = sum + num + (number/num);
		}
	    }
	    num++;
	}
        
        
        return sum;
    }
    
    public static int count_numbers_factors(long number) {
	int count = 0;
	if(number == 1 ) return 1;
	long num = 1;
	double sqrt = Math.sqrt(number);
	while(num<=sqrt) {
	    if(number%num==0) {
		if(num ==sqrt) {
		    count = count + 1;
		}else {
		    count = count+2;
		}
	    }
	    num++;
	}
	
	return count;    
    }
    
    public static void simplify_fraction(int num, int deno, int[] result) {

	int n = 1;
	int d = 1;
	if(num>deno) {
	     n = num;
	     d = deno;
	}else {
	    n = deno;
	    d = num;
	}
	int gcd = findGCD(n,d);
	result[0] = num/gcd;
        result[1] = deno/gcd;
        System.out.println(result[0] +" :: "+ result[1]);
    }

    private static int findGCD(int n, int d) {

	while(d>0) {
	    int temp = d;
	    d = n%d;
	    n = temp;
	}
	return n;
    }

}
