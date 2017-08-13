package hacker.warmup;

import java.util.Scanner;

public class FunnyString {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int noOfTestcases = in.nextInt();
		String[] strArray = new String[noOfTestcases];
		for(int i=0;i<noOfTestcases;i++){
			strArray[i] = in.next();
		}
		for(String str : strArray){
			printFunny(str);
		}
		
	}

	private static void printFunny(String str) {
		
		char[] charArray = str.toCharArray();
		int length = str.length();
		boolean funny = true;
		for (int i=0,j=length-1;i<length-1 && j>0 && i<=j;i++,j--){
			if(Math.abs(charArray[i]-charArray[i+1])!=Math.abs(charArray[j]-charArray[j-1])){
				funny = false;
				break;
			}
		}
		if(funny){
			System.out.println("Funny");
		}else{
			System.out.println("Not Funny");
		}
		
	}

}
