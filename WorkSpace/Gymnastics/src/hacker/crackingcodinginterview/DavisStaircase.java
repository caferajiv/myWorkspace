package hacker.crackingcodinginterview;

import java.util.Scanner;

public class DavisStaircase {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        for(int a0 = 0; a0 < s; a0++){
	            int n = in.nextInt();
	            System.out.println(findStepsDP(n));
	        }
		
	}

	private static int findSteps(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		return findSteps(n-1)+findSteps(n-2)+findSteps(n-3);
		
	}
	
	
	private static int findStepsDP(int n) {
		int arr[] = new int[n + 1];
		arr[0] = 0;
		if (n >= 1) {
			arr[1] = 1;
		}
		if (n >= 2) {
			arr[2] = 2;
		}
		if (n >= 3) {
			arr[3] = 4;
		}

		for (int i = 4; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}

		return arr[n];}
}

