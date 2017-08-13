package hacker.warmup;

import java.util.Scanner;

public class MakeAnagram {
	
	public static void main(String[] args) {
		
		Scanner in  = new Scanner(System.in);
		
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		
		int deletions = deletionsNeeded(str1, str2);
		System.out.println(deletions);
		
	}

	private static int deletionsNeeded(String str1, String str2) {
		char a = 'a';
		char z = 'z';
		int[] arr = new int[126];
		for(int i='a';i<='z';i++){
			arr[i]=0;
		}
		char[] charArray1 = str1.toCharArray();
		for(char c: charArray1){
			arr[c] = arr[c]+1;
		}
		char[] charArray2 = str2.toCharArray();
		for(char d: charArray2){
			arr[d] = arr[d]-1;
		}
		
		int sum = 0;
		
		for(int j : arr){
			sum =  sum + Math.abs(j);
		}
			
		
		return sum;
	}

}
