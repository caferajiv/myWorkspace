package coderust.misc;

public class SearchInMatrix {
	
	public static void main(String[] args) {
		int value = 16;
		int[][] matrix = {{2,4,9,13},{3,5,11,18},{6,8,16,21},{9,11,20,25}};
		System.out.println(search_in_matrix(matrix, value));
	}
	
	public static IntPair
	search_in_matrix(int arr[][], int value) {

		for(int i=0,j=arr[i].length-1;i<arr.length && j>=0;) {
			if(value == arr[i][j]) return new IntPair(i, j);
			if(value>arr[i][j]) {
				i++;
			}else {
				j--;
			}
		}

		return new IntPair(-1, -1);
	}
	
	static class IntPair {
		int i;
		int j;
		IntPair(int i, int j){
			this.i = i;
			this.j = j;
		}
		
		@Override
		public String toString() {
			return "i: "+i+" j: "+j;
		}
	}

}
