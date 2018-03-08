package hacker.crackingcodinginterview;

import java.util.Scanner;

public class Bitwise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(findLonely(arr));
	}

	private static int findLonely(int[] arr) {
		int a= arr[0];
		for(int i=1; i<arr.length;i++) {
		 	a = a ^ arr[i];
		}
		return a;
	}

}
