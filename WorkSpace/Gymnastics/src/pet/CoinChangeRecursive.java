package pet;

public class CoinChangeRecursive {
	
	public static void main(String[] args) {
		int[] coins = {1,2,5,10,20,25};
		int total = 40;
				
		// not working 
		System.out.println(getChangeWithRecursiveDP(total,coins));
	}

	private static int getChangeWithRecursiveDP(int total, int[] coins) {

		
		if(total < 0) return -1;
		if (total == 0) return 0;
		int[] arr = new int [total+1];
		for(int coin : coins) {
			if(coin == total) return 1;
			if(coin<total) {
				arr[coin] = 1;
			}else {
				break;
			}
		}
		if(arr[total] >0) return arr[total];
		
		int ans = -1;
		for(int i=0;i<coins.length;i++) {
			ans = Math.min(ans,getChangeWithRecursiveDP(total-coins[i], coins));
		}
		return arr[total] = ans +1;
	}

}
