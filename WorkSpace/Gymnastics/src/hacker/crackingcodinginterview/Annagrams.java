package hacker.crackingcodinginterview;

import java.util.Scanner;

public class Annagrams {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		System.out.println(checkAnagram(a,b));
	}

	private static int checkAnagram(String a, String b) {
		int[] arr = new int[26];  
		for(int i=0;i<a.length();i++) {
			char c= a.charAt(i);
			arr['z'-c] = arr['z'-c]+1;
		}
		
		for(int i=0;i<b.length();i++) {
			char c= b.charAt(i);
			arr['z'-c] = arr['z'-c]-1;
		}
		int sum = 0;
		
		for(int i: arr) {
			sum = sum +Math.abs(i);
		}
		
		return sum;
	}
	

	
	


}
