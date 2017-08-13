package geeks.practice.recursion;

import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class StringPermutation {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();

		String[] inputArray = new String[testcases];
		for(int i=0;i<testcases;i++){
			
			inputArray[i] = in.next();
		}
		
		for(int i=0;i<testcases;i++){
			SortedSet<String> perms = findAllPermutations(inputArray[i]);
			perms.add(inputArray[i].substring(0));
			System.out.println();
			for(String s : perms){
				System.out.print(s+ " ");
			}
		}


	}

	private static SortedSet<String> findAllPermutations(String input) {

		SortedSet<String> perm = new TreeSet<String>();
		if(input.length()==0) {
			perm.add("");
			return perm;
		}
		char c = input.charAt(0);
		String rem = input.substring(1);
		Set<String> words = findAllPermutations(rem);

		for(String s : words){
			for(int i=0;i<=s.length();i++){
				perm.add(insertChar(c,i,s));
			}
		}

		return perm;

	}

	private static String insertChar(char c, int i,String s) {
		return s.substring(0,i)+String.valueOf(c)+s.substring(i);
	}

}
