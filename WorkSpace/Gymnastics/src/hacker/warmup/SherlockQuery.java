package hacker.warmup;

import java.math.BigInteger;
import java.util.Scanner;

public class SherlockQuery {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
   		
		int n = in.nextInt();
		int m = in.nextInt();
		
		BigInteger[] A = new BigInteger[n];
		BigInteger[] B = new BigInteger[m];
		BigInteger[] C = new BigInteger[m];
		
		for(int i=0;i<n;i++)
		{
			A[i]=new BigInteger(in.next());
		}
		
		for(int i=0;i<m;i++)
		{
			B[i]=new BigInteger(in.next());
		}
		
		for(int i=0;i<m;i++)
		{
			C[i]=new BigInteger(in.next());
		}
		
		
		for( int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if (j % B[i].longValue() == 0){
					
					 A[j] = A[j].multiply(C[i]);
				}
			           
			}
		}
		
		
		for(int i=0;i<n;i++)
		{
			System.out.print(A[i]+" ");
		}
				
	}

}
