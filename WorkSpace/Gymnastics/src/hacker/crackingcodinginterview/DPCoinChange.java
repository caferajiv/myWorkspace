package hacker.crackingcodinginterview;

import java.util.Scanner;

public class DPCoinChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(findChangeDP2(n,coins));
    }

	private static long findChangeDP2(int n, int[] coins) {
		long arr[] = new long[n+1];
		arr[0] = 1L;
		for(int coin : coins) {
			for (int i = coin; i <= n; i++) {
				arr[i] = arr[i] + arr[i - coin];
			}
		}
		return arr[n];
	}

}
