package hacker.crackingcodinginterview;

import java.util.Scanner;

public class StaircaseProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i: arr) {
			System.out.println(stepsRequiredDP(i));
		}
	}

	private static int stepsRequired(int i) {
		int[] arr= new int[i+5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		if(i>3) {
		arr[i] = stepsRequired(i-1)+stepsRequired(i-2)+stepsRequired(i-3);
		}
		return arr[i];
	}
	
	private static int stepsRequiredDP(int n) {
		int[] arr= new int[n+5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		if(n>3) {
			int i=4;
			while(i<=n) {
				arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
				i++;
			}
		}
		return arr[n];
	}

}
