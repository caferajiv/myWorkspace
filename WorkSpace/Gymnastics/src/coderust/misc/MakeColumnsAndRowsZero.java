package coderust.misc;

import java.util.ArrayList;
import java.util.List;

public class MakeColumnsAndRowsZero {
	
	public static void main(String[] args) {
		int[][] matrix = {{5,4,3,9},{2,0,7,6},{1,3,4,0},{9,8,3,4}};
		
		print(make_zeroesBetter(matrix));
	}
	
	private static int[][] make_zeroesBetter(int[][] arr) { //O(n2)
       
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			for (int j=0;j<arr.length;j++) {
				if(arr[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int row : rows) {
			for (int j=0;j<arr[row].length;j++){
				arr[row][j] = 0;
			}
		}
		
		for(int col : cols) {
			for (int i=0;i<arr.length;i++){
				arr[i][col] = 0;
			}
		}

		return arr;
	}

	private static void print(int[][] matrix) {
		
		for(int[] arr : matrix ) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}

	static int[][] make_zeroes(int[][] arr) {  // O(n3)
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			for (int j=0;j<arr.length;j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = max;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				if(arr[i][j] == max) {
					for(int k =0;k<arr[i].length;k++) {
						if(arr[i][k]!=max) {
							arr[i][k] = 0;
						}
					}
					
					for(int k =0;k<arr.length;k++) {
						if(arr[k][j]!=max) {
							arr[k][j] = 0;
						}
					}
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for (int j=0;j<arr.length;j++) {
				if(arr[i][j] == max) {
					arr[i][j] = 0;
				}
			}
		}
		return arr;
	  }

}
