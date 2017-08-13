package hacker.arraysSort;

import java.math.BigInteger;
import java.util.Scanner;

public class CavityMap {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
   		
		int n = in.nextInt();
		BigInteger[][] origArray=new BigInteger[n][n];
		
		for(int i=0;i<n;i++){
			BigInteger number = new BigInteger(in.next());
			
			for(int j=n-1;j>=0;j--){
				BigInteger digit = number.mod(BigInteger.TEN);
				number = number.divide(BigInteger.TEN);
				origArray[i][j]=digit;
				//System.out.println(origArray[i][j]);
			}
		}
		
		
		for(int i=1;i<n-1;i++){
			for(int j=1;j<n-1;j++){
				if(origArray[i][j].compareTo(origArray[i][j-1])>0 && origArray[i][j].compareTo(origArray[i-1][j])>0 && origArray[i][j].compareTo(origArray[i][j+1])>0 && origArray[i][j].compareTo(origArray[i+1][j])>0){
					origArray[i][j]=BigInteger.TEN;
				};
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(origArray[i][j].equals(BigInteger.TEN)){
					System.out.print('X');
				}else{
					System.out.print(origArray[i][j]);
				}
			}
			System.out.println();
		}
		
	}

}
