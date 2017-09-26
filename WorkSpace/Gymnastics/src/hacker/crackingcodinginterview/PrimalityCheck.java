package hacker.crackingcodinginterview;

import java.util.Scanner;

public class PrimalityCheck {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int p = in.nextInt();
	        int[] arr = new int[p];
	        for(int a0 = 0; a0 < p; a0++){
	            arr[a0] = in.nextInt();
	        }
	        
	        for(int a : arr){
	            System.out.println(checkPrime(a));
	        }
	}

	private static String checkPrime(int a) {
		if(a==0 || a==1) return "Not prime";
		for(int i=2;i<=Math.sqrt(a);i++){
			if(a%i==0) return "Not prime";
		}
		return "Prime";
	}

}
