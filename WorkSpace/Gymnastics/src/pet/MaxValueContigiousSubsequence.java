package pet;

public class MaxValueContigiousSubsequence {
	
	public static void main(String[] args) {
		int[] arr = {-2,11,-4,13,-5,2};
		
		System.out.println(findMaxContigiousSubsequence(arr));
		
	}

	private static int findMaxContigiousSubsequence(int[] arr) {

		int sumSoFar = 0;
		int sumEndingHere = 0;
		for(int i =0;i<arr.length;i++) {
			if(arr[i]<0 && sumEndingHere==0) continue;
			sumEndingHere += arr[i];
			if(sumEndingHere > 0) {
				sumSoFar = Math.max(sumEndingHere,sumSoFar);
			}else {
				sumEndingHere = 0;
				
			}
			
		}
		return sumSoFar;
	}

}
