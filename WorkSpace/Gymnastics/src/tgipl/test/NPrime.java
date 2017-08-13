package tgipl.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NPrime {
	
	public static void main(String[] args) {
		
		int n=100;
		
		System.out.println(firstNPrimes(n));
		
		
	}
	
	public static List<Integer> firstNPrimes(int n){
		List<Integer> listOfPrimes = new ArrayList<Integer>();
		int num = 1;
		while(listOfPrimes.size()<n)
		{
			if(listOfPrimes.size()!=0)
			{
				//diving numbers from the list of  primes because all 
				//non-prime numbers can be represented as factors of prime numbers
				for(int prime : listOfPrimes)
				{
					if(num%prime==0)
					{
						break;
					}
					//list will return me prime numbers in ascending order so
					//when the prime number reaches num/2 i need not go further 
					if(prime>num/2)
					{
						listOfPrimes.add(num);
						//list of integers anyhow will be sorted in natural order 
						// but still there is no guarantee so sorting while adding
						// new number to list
						Collections.sort(listOfPrimes);
						break;
					}
					
				}
			}
			else
			{
				for(int j=2;j<=num;j++)
				{
					if(num%j==0 && j==num)
					{
						listOfPrimes.add(num);
					}
				}
			}
			num++;
		}
		return listOfPrimes;
	}

}
