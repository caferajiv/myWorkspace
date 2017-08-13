package pet;

public class SpiralMatrix {
	
	public static void main(String[] args) {
		/**
		 *  1   2   3   4    5
         *  6   7   8   9    10
         *  11  12  13  14   15
         *  16  17  18  19   20
         *  21  22  23  24   25
		 */
		
		int[][] matrix = new int[5][5];
		
		buildMatrix(matrix);
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		printSpiral(matrix, rowLength,colLength);
		
	}

	private static void printSpiral(int[][] matrix, int rowLength, int colLength) {
		int i=0;
		int round = 0;
		int checkVal = rowLength/2;
		if(rowLength%2!=0){
			checkVal++;
		}
		while(round<checkVal && i<rowLength){
			int j=i;
			while(j<colLength-round){
				print(matrix, i, j);
				j++;
			}
			j--;
			i++;
			while(i<rowLength-round){
				print(matrix, i, j);
				i++;
			}
			i--;
			j--;
			while(j>=0+round){
				print(matrix, i, j);
				j--;
			}
			i--;
			j++;
			while(i>round){
				
				print(matrix, i, j);
				i--;
			}
			i++;
			round++;
		}
		
	}

	private static void print(int[][] matrix, int i, int j) {
		System.out.print(matrix[i][j]+" ");
	}

	private static void buildMatrix(int[][] matrix) {
		matrix[0][0]=1;matrix[0][1]=2;matrix[0][2]=3;matrix[0][3]=4;matrix[0][4]=5;
		matrix[1][0]=6;matrix[1][1]=7;matrix[1][2]=8;matrix[1][3]=9;matrix[1][4]=10;
		matrix[2][0]=11;matrix[2][1]=12;matrix[2][2]=13;matrix[2][3]=14;matrix[2][4]=15;
		matrix[3][0]=16;matrix[3][1]=17;matrix[3][2]=18;matrix[3][3]=19;matrix[3][4]=20;
	    matrix[4][0]=21;matrix[4][1]=22;matrix[4][2]=23;matrix[4][3]=24;matrix[4][4]=25;

	}

}
