package coderust.dp;

public class CoinChanging {
	public static void main(String[] args) {
		
		int[] denominations = {1,5,10};
		int amount = 356;
		System.out.println(solve_coin_change_dp(denominations,amount));
		
	}
	
	static int solve_coin_change_dp(int[] coins, int n) {

		int [] arr = new int[n+1];
		
		for(int coin : coins) {
			if(coin<=n) {
				arr[coin] = 1;
			}
		}
		
		if(arr[n]!=0) return arr[n];
		
		for(int coin: coins) {

			for(int i=coin;i<=n;i++) {
				if(arr[i]>0) {
					arr[i] = Math.min(arr[i], 1+arr[i-coin]);
				}else {
					arr[i] = 1 + arr[i-coin];
				}
			}

		}
		


		return arr[n];
	}

}
