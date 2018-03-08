package hacker.crackingcodinginterview;

import java.util.Scanner;

public class DPCoin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[c];
		for(int i=0;i<c;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(findChange(arr, d));
	}

	private static long findChange(int[] arr, int d) {
		long[] dparr = new long[d+2];
		dparr[0] = 1;
		
		for(int i : arr) {
			for(int j=i; j<=d;j++) {
				dparr[j]  += dparr[j-i];
			}
		}
				
		return dparr[d];
	}

}
