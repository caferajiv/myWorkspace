package pet;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringCombination {
	public static void main(String[] args) {
		
		String input = "ABC";	
		printAllCombinations(input);
		
		
	}

	private static void printAllCombinations(String input) {
		int strLength = input.length();
		int totalCombinations = (int) Math.pow(2,strLength);
		
		for(int i=1;i<totalCombinations;i++){
			System.out.println();
			String formattedString = String.format("%"+strLength+"s",Integer.toBinaryString(i)).replace(' ','0');
			print(input,formattedString);
			
		}
		
	}

	private static void print(String input, String binaryString) {
		for(int i=0;i<input.length();i++){
			if(binaryString.charAt(i)=='1'){
				System.out.print(input.charAt(i));
			}
		}
		
	}
	
	

	


}
