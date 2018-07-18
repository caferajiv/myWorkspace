package coderust.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		
		String word = "   Quick brown fox jumped   over lazy   dog           ";
		System.out.println(remove_duplicates(word.toCharArray()));
	}
	
	static char[] remove_duplicates(char[] str){
	      Set<Character> set = new HashSet<>();
	      set.add(str[0]);
	      int i =1,j=1;
		while (i<str.length) {
			if(set.contains(str[i])) {
				i++;
			}else {
				set.add(str[i]);
				str[j] = str[i];
				j++;
				i++;
			}
			
		}
		
		while(j<str.length) {
			str[j++] = '\0';
		}
		
		return str;
	  }

	
}
