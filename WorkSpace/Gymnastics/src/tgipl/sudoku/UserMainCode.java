package tgipl.sudoku;

import java.io.*;

public class UserMainCode
{
	//Assume following return types while writing the code for this question. 
    //	public static int[-] output1;
	
	private static final int GRIDSIZE=9;
	
	private static int [][] sudokuGrid;
	
	private static void initializeSudoku()
	{
		sudokuGrid= new int[][]{{0,0,0,0,5,8,4,2,0},
								{0,8,9,2,4,1,6,0,7},
								{5,4,2,3,0,6,0,8,0},
								{0,0,0,8,3,0,2,4,0},
								{0,7,3,0,0,0,0,9,0},
								{2,0,0,1,9,5,3,7,0},
								{0,3,0,7,0,0,8,6,9},
								{0,0,6,0,0,0,0,0,4},
								{7,9,8,0,6,3,5,1,0}};	
	}

public static int[][] getSudokuGrid() {
		return sudokuGrid;
	}

	public static void setSudokuGrid(int[][] sudokuGrid) {
		UserMainCode.sudokuGrid = sudokuGrid;
	}

public static void SolveSudoku(int[][] input1)
{
      initializeSudoku();
      
}	
}