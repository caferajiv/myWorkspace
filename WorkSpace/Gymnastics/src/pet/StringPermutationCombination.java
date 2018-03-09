package pet;

import java.util.HashSet;
import java.util.Set;

public class StringPermutationCombination {
	public static void main(String[] args) {
		String input = "ABC";
		
		Set<String> perms = findAllPermutations(input);
		
		for(String s : perms){
		//	System.out.println(s);
		}
		
		printAllCombinations(input);
	}

	private static void printAllCombinations(String input) {

		int length = input.length();
		int totalCombinations = (int)Math.pow(2, length);
		
		for(int i=1;i<totalCombinations;i++) {
			System.out.println();
			String formattedString = String.format("%"+length+"s", Integer.toBinaryString(i).replace(' ', '0' ));
			print(input,formattedString);
		}
	}

	private static void print(String input, String formattedString) {

		for(int i=0;i<input.length();i++) {
			if(formattedString.charAt(i)=='1')System.out.print(input.charAt(i));
		}
		
	}

	private static Set<String> findAllPermutations(String input) {

		Set<String> set = new HashSet<>();
		if(input.length()==0) {
			set.add("");
			return set;
		}

		char c = input.charAt(0);
		String rem = input.substring(1);
		Set<String> words = findAllPermutations(rem);
		
		for(String s: words) {
			for(int i=0;i<=s.length();i++) {
				set.add(s.substring(0, i)+String.valueOf(c)+s.substring(i));
			}
		}

		return set;
	}

}
