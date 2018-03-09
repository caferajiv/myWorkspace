package pet;

public class CoinChange {
	public static void main(String[] args) {
		int[] coins = {1,3,9,10};
		int total = 15;
				
		System.out.println(getChange2(total,coins));
		
	}
	
	private static int getChange(int total, int[] coins) {
		
		int[] arr = new int[total+2];
		arr[0] = 0;
		arr[1] = 1;
		arr[3] = 3;
		arr[9] = 9;
		arr[10] = 10;
		if(total ==  0 || total == 1 ||
				total == 3 || total == 9 || total == 10) return arr[total];
		for(int coin: coins) {
			for(int i=coin;i<=total;i++) {
				arr[i] = arr[i] + arr[i-coin];
			}
		}
		
		return arr[total];
	}
	
	
	private static int getChange2(int total, int[] coins) {
		
		int[] arr = new int[total+2];
		arr[0] = 0;
		arr[1] = 1;
		arr[3] = 3;
		arr[9] = 9;
		arr[10] = 10;
		if(total ==  0 || total == 1 ||
				total == 3 || total == 9 || total == 10) return arr[total];
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
