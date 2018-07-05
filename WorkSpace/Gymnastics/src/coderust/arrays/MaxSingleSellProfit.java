package coderust.arrays;


public class MaxSingleSellProfit {

	public static void main(String[] args) {
		//int[] arr = {1, 2, 3, 4, 3, 2, 1, 2, 5};
		
		//int[] arr = {12,5,9,19,8};
		
		int[] arr = {21,12,11,9,6,3};


		System.out.println(find_buy_sell_stock_pricesBetter(arr));

	}

	public static Tuple find_buy_sell_stock_prices(   //O(n2)
			int[] arr) {


		int[] max_profit = new int[arr.length];
		int[] indexes = new int[arr.length];
		max_profit[0] = Integer.MIN_VALUE;

		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				int diff = arr[i] - arr[j];
				if(diff>max_profit[i]) {
					max_profit[i] = diff;
					indexes[i] = j;
				} 
			}
		}

		int maxProfit = Integer.MIN_VALUE;
		int x = 0;
		int y = 0;
		for(int i=1;i<arr.length;i++) {

			if (maxProfit<max_profit[i]) {
				maxProfit = max_profit[i];
				x = indexes[i];
				y = i;
			}
		}

		return new Tuple<Integer, Integer>(arr[x], arr[y]);
	}


	public static Tuple find_buy_sell_stock_pricesBetter(   //O(n)
			int[] arr) {


		int current_buy = arr[0];
		int current_sell = arr[1];
		
		int max_profit = current_sell - current_buy;
		
		int current_profit = Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++) {
			current_profit = arr[i]-current_buy;
			
			if(current_profit>max_profit) {
				max_profit = current_profit;
				current_sell = arr[i];
			}
			
			if(current_buy > arr[i]) {
				current_buy = arr[i];
			}
		}
		
		int buyPrice = current_sell-max_profit;
		return new Tuple<Integer, Integer> (buyPrice, current_sell);

	}
	
	
	static class Tuple<X, Y> { 
		public X x; 
		public Y y; 

		public Tuple(X x, Y y) { 
			this.x = x; 
			this.y = y; 
		} 
		
		@Override
		public String toString() {
			//Buy Price: 1 Sell Price: 5
			return "Buy Price: "+x.toString() +" Sell Price: "+ y.toString();
		}
	}

}
