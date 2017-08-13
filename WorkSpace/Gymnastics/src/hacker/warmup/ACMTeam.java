package hacker.warmup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACMTeam {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
	   		
		int persons = in.nextInt();
		int topics = in.nextInt();
		
		//BigInteger test = new BigInteger("1001101111101011011100101100100110111011111011000100111100111110111101011011011100111001100011111010");
		//System.out.println(test.and(test));
		
		//System.out.println(test);
		BigInteger[] binaries = new BigInteger[persons];
		for(int i=0;i<persons;i++)
		{
			binaries[i] = new BigInteger(in.next(),2);
			//System.out.println();
		}
		
		List<BigInteger> maxteam  = new ArrayList<BigInteger>(); 
		
		
		for(int i=0;i<persons-1;i++){
			for(int j=i+1;j<persons;j++){
				maxteam.add(binaries[i].or(binaries[j]));
				
				
			}
		}
		int max = Integer.MIN_VALUE;
		int count=1;
		
		for(BigInteger a : maxteam){
			int bitCount = a.bitCount();
			if(max<bitCount){
				max=bitCount;
				count=1;
			}else if(max==bitCount){
				count++;
			}
		}
		
		System.out.println(max);
		System.out.println(count);
		
		
	}

}
