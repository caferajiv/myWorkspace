package cracking.dp;

public class CoinChange {
	
	public static void main(String[] args) {
		
		int[] coins = {1,4,6,9,11};
		
		System.out.println(findMinCoins(18,coins));
		
	}

	private static int findMinCoins(int n, int[] coins) {
		int[] arr = new int[n+2];
		for(int coin : coins) {
			if(coin == n) return 1;
			if(coin < n) {
				arr[coin] = 1;
			}else {
				break;
			}
		}
		
		for(int coin : coins) {
			for(int i= coin;i<=n;i++) {
				arr[i] = arr[i-coin]+1;
			}
		}
		return arr[n];
	}

}
