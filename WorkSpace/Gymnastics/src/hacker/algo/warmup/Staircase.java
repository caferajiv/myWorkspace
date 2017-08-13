package hacker.algo.warmup;

import java.util.Scanner;

public class Staircase {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		 int staircases = in.nextInt();
		 for(int i=staircases;i>0;i--){
			 int spaces = i-1;
			 while(spaces>0){
			 System.out.print(" ");
			 spaces--;
			 }
			
			 int hashes = (staircases-i)+1;
			 while(hashes>0){
				 System.out.print("#");
				 hashes--;
				 }
			 System.out.println();
		 }
		 }
}
	


