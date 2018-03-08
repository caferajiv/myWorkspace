package hacker.crackingcodinginterview;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibonaci(n)); 
		
	}

	private static int fibonaci(int n) {
		int[] arr = new int[n+2];
		if(n==0) {
			arr[0] = 0;
		}
		else if(n==1) {
			arr[1] = 1;
		}else {
			arr[n] = fibonaci(n-1)+fibonaci(n-2);
		}
		
		return arr[n];
	}

}
