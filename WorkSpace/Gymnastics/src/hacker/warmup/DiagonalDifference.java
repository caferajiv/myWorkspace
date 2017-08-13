package hacker.warmup;

import java.util.Scanner;

public class DiagonalDifference {
	
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		
	int n = in.nextInt();
	int array[][] = new int[n][n];
	for(int i=0;i<n;i++){
		for (int j=0;j<n;j++){
			array[i][j]=in.nextInt();
		}
		
	}
	int diff = findDiff(array);
	System.out.println(diff);
	
}

private static int findDiff(int[][] array) {
	int diff=0;
	int n= array.length;
	for(int i=0;i<n;i++){
		
			diff = diff + array[i][i] - array[i][n-1-i];
	
	}
	
	return Math.abs(diff);
}

}
