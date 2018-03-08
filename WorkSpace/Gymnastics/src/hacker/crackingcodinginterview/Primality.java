package hacker.crackingcodinginterview;

import java.util.Scanner;

public class Primality {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i: arr) {
			System.out.println(isPrime(i));
		}
	}

	private static String isPrime(int n) {
		if(n==1 || n==0) return "Not prime";
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) return "Not prime";
		}
		return "Prime";
	}

}
