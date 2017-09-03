package practice.search.sort;

public class SumOf3EqualsK {
	
	public static void main(String[] args) {

		int[] arr = { 1, 3, 25, 36, 78, 100, 111, 125, 130, 144, 159, 178 };

		int K = 303;
		int low = 0;
		int high = arr.length - 1;
		findSumOf3EqualsK(arr, low, high, K);

	}

	private static void findSumOf3EqualsK(int[] arr, int low, int high, int k) {
		
		for(int i=0;i<high;i++){
			{
				int sum = k-arr[i];
				findSumOf2EqualsK(arr, i+1, high, sum, i);
			}
			
		}
		
	}
	
	private static boolean findSumOf2EqualsK(int[] arr, int low, int high, int K,int index) {
		if(low>high) return false;
		int mid = (high-low)/2 + low;
		while(low<high && high>low){
			if(arr[low]+arr[high]>K) high--;
			else if(arr[low]+arr[high]<K)low++;
			else if(arr[low]+arr[high]==K){ System.out.println("index: "+arr[index]+
					" low: "+arr[low]+ " high: "+arr[high]); return true;}
		}
		return false;
	}

}
