package pet;

public class CoinChange {
	public static void main(String[] args) {
		//int[] coins = {1,3,9,10};
		
		int[] coins = {1,2,5,10,20,25};
		int total = 40;
				
		System.out.println(getChangeWithDP(total,coins));
		
	}
	
	private static int getChangeWithDP(int total, int[] coins) {
		
		int[] arr = new int[total+2];
		for(int coin : coins) {
			if(coin == total) return 1;
			if(coin<total) {
				arr[coin] = 1;
			}else {
				break;
			}
		}
		for(int coin: coins) {
			for(int i=coin;i<=total;i++) {
				arr[i] = 1 + arr[i-coin];
			}
		}
		
		return arr[total];
	}
	
	
	private static int getChangeWithoutDP(int total, int[] coins) {
		
		int[] arr = new int[total+2];
		for(int coin : coins) {
			if(coin == total) return 1;
			if(coin<total) {
				arr[coin] = 1;
			}
		}
		int count=0;
		while(total>0) {
			for(int i=coins.length-1;i>=0;i--) {
				if(total>=coins[i]) {
				//arr[total] = arr[total -coins[i]]+1;
				total = total -coins[i];
				count++;
				}
			}
		}
		
		
		return count;
	}

}
