package practice.search.sort;

public class SumOf2EqualsK {
	
	public static void main(String[] args) {
		
		int[] arr = {1,3,25,36,78,100,111,125,130,144,159,178};
		
		int K = 278;
		int low = 0;
		int high = arr.length-1;
		findSumOf2EqualsK(arr,low, high, K);
	}

	private static void  findSumOf2EqualsK(int[] arr, int low, int high, int K) {
		if(low>high) return;
		int mid = (high-low)/2 + low;
		while(low<high && high>low){
			if(arr[low]+arr[high]>K) high--;
			else if(arr[low]+arr[high]<K)low++;
			else if(arr[low]+arr[high]==K){ System.out.println("low: "+arr[low]+ " high: "+arr[high]); return;}
		}
	}

}
