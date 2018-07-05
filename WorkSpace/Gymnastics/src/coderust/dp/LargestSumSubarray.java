package coderust.dp;

public class LargestSumSubarray {

	public static void main(String[] args) {
		int[] arr = {-4,2,-5,1,2,3,6,-5,1};
		System.out.println(find_max_sum_sub_arrayBetter(arr));
	}
	
	private static int find_max_sum_sub_arrayBetter(int[] arr) { //O(n)
		
		int sumSofar = arr[0];
		int sumEndingHere= arr[0];
		for(int i=1;i<arr.length;i++) {
			
			if(sumEndingHere<0) {
				sumEndingHere = arr[i];
			}else {
				sumEndingHere = sumEndingHere+arr[i];
			}
			
			
			if(sumEndingHere>sumSofar) {
				sumSofar = sumEndingHere;
			}
		}
		
		return sumSofar;
	}

	static int find_max_sum_sub_array(int[] arr) {  //O(n2)
		
		int[][] matrix = new int[arr.length][arr.length];
		matrix[0][0] = arr[0];
		for(int i = 1;i<arr.length;i++) {
			for(int j=0;j<=i;j++) {
				matrix[i][j] = matrix[i-1][j] + arr[i];
			}
		}
		
		int max = Integer.MIN_VALUE;
		int iIndex = 0;
		int jIndex = 0;
		
		for(int i = 0;i<arr.length;i++) {
			for (int j=0;j<=i;j++ ) {
				if(matrix[i][j]>max) {
					max = matrix[i][j];
					iIndex = i;
					jIndex = j;
				}
			}
		}
		
		
	    
	      return max;
	  }
}
