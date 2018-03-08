package hacker.crackingcodinginterview;

import java.util.Scanner;

public class ArraysLeftRotation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraylength = sc.nextInt();
		int d = sc.nextInt();
		int[] arr = new int[arraylength];
		
		for(int i =0;i<arraylength; i++) {
			arr[i] = sc.nextInt();
		}
		
		//print(arr);
		rotateleft(arr,d);
		//print(arr);
		
		
	}

	private static void rotateleft(int[] arr, int d) {

		int[] copyarr = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int newIndex = i - d;
			if(newIndex<0) newIndex+=arr.length;
			copyarr[newIndex] = arr[i];
		}
		
		print(copyarr);

	}

	private static void print(int[] arr) {
		for(int i: arr) {
			System.out.print(i+" ");
		}
		
	}

}
