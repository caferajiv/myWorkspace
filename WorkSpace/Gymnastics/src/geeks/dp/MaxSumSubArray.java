package geeks.dp;

public class MaxSumSubArray {
	
	public static void main(String[] args) {
		int[] arr = {-27, -36, 41, 11, -47, -32, 47, -56, -38, 57, -63, -41, 23, 41, 29, 78, 16, 
				-65, 90, -58, -12, 6, -60, 42, -36, -52, -54, -95, -10, 29, 70, 50, -94, 1};
		
		int maxSum = findMaxSubSubArray(arr);
		System.out.println(maxSum);
	}

	private static int findMaxSubSubArray(int[] arr) {
		int sumSofar = 0;
		int sumEndingHere = 0;
		int startIndex= 0;
		int oldStartIndex =0;
		int endIndex=0;
		for(int i=0;i<arr.length;i++) {
			if(sumEndingHere+arr[i]>0) {
				sumEndingHere = sumEndingHere+arr[i];
				
			}else {
				sumEndingHere = 0;
				if(startIndex<endIndex) {
					oldStartIndex = startIndex;
				}
				
				startIndex = i+1;
				
			}
			
			if(sumSofar<sumEndingHere) {
				sumSofar = sumEndingHere;
				endIndex = i;
			}
		}
		System.out.println(oldStartIndex);
		System.out.println(endIndex);
		int maxNegative = 0;
		for(int i =oldStartIndex;i<=endIndex;i++) {
			if(arr[i]<maxNegative) {
				maxNegative = arr[i];
			}
		}
		
		return sumSofar-maxNegative;
	}

}
