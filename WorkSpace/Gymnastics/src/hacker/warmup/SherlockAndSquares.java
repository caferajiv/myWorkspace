package hacker.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAndSquares {
	
	private static List<Integer> squareList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
   		
		int noOfTestCases = in.nextInt();
		
		int[][] numbers = new int[noOfTestCases][2];
		
		for(int i=0;i<noOfTestCases;i++){
			numbers[i][0]=in.nextInt();
			numbers[i][1]=in.nextInt();
		}
		
		
		
		//preComputeSquares();
		
		for(int i=0;i<noOfTestCases;i++){
			
			countSquares2(numbers[i][0],numbers[i][1]);
		}
	}

	private static void preComputeSquares() {
		for(int i=1;i<100000;i++){
			int square = i*i;
			if(square<1000000000){
				squareList.add(square);
			}
		}
		
	}

	private static void countSquaresSlow(int a, int b) {

		int count=0;
		for(int i=a;i<=b;i++){
			
			if(Math.sqrt(i)%1==0){
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	private static void countSquares2(int a, int b) {

		double count=Math.ceil(Math.sqrt(a)) - Math.floor(Math.sqrt(b))+1;
		
		
		
		System.out.println(count);
		
	}

}
