package hacker.algo.impl;

import java.util.Scanner;

public class Bonetrousle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		for(int i=0;i<testcases;i++){
			 int sum = in.nextInt();
			 int array = in.nextInt();
			 int num = in.nextInt();
			 int minSum = num*(num+1)/2;
			 int maxSum = 0;
			 
			 int count = num-1;
			 while(count>=0){
				 maxSum = maxSum + (array-count);
				 count--;
			 }
			 			 
			 if(sum  < minSum || sum >maxSum || num > array){
				 System.out.println(-1);
				 continue;
			 }
			 if(num == 1 ){
				 System.out.println(sum);
				 continue;
			 }
			 
			 int incrementBy = (array-1)/num;
			 
			 int calc = minSum;
			 int counter =0;
			 while(calc<sum){
				 calc = calc + incrementBy*num;
				 counter++;
			 }
			  
			 
			 
			 
			 
			 
			 
		}
		
		 
		 
	}

}
