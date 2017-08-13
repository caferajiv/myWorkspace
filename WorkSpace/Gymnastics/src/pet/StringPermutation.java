package pet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {
	public static void main(String[] args) {
		
		String input = "ABC";
		System.out.println(input.substring(0));
		
		Set<String> perms = findAllPermutations(input);
		
		for(String s : perms){
			System.out.println(s);
		}
	}

	private static Set<String> findAllPermutations(String input) {
		
		Set<String> perm = new HashSet<String>();
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
