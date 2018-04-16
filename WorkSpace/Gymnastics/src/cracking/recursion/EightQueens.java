package cracking.recursion;

import java.util.ArrayList;

public class EightQueens {
	
	private static int GRID_SIZE = 8;
	public static void main(String[] args) {
		int row = 1;
		Integer[]columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]>results = new ArrayList<>();
		placeQueens(row,columns,results);
		
	}
	private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if(row==GRID_SIZE) {
			results.add(columns.clone());
		}else {
			for(int i =0; i<GRID_SIZE;i++) {
				if(checkValid(columns, row,i)) {
					columns[row] = i;
					placeQueens(row+1, columns, results);
				}
			}
		}
		
	}
	private static boolean checkValid(Integer[] columns, int row1, int column1) {
		for(int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			
			if(column2 == column1) {
				return false;
			}
			
			int columnDistance = Math.abs(column2-column1);
			
			int rowDistance = row1-row2;
			if(columnDistance == rowDistance) {
				return false;
			}
			
		}
		return true;
	}

}
