package pet;

import java.util.HashSet;
import java.util.Set;

public class DeleteStringChars {
	
	private static final String INVALID_DATA= "Invalid data!!";
	
public static void main(String[] args) {
	String s1 = "aeiou";
	String s2 = "I am aa very gentle human being";
	
	System.out.println(deleteFirstFromSecond(s1,s2));
			
}

private static String deleteFirstFromSecond(String s1, String s2) {
	if(s2.length()==0) return INVALID_DATA;
	
	Set<Character> set = new HashSet<Character>();
	int length= s1.length();
	
	for(int i = 0;i<length ; i++){
		set.add(s1.charAt(i));
	}

	/**
	 * 
	 * loop through the hashset and remove chars
	 */
/*	
	for(Character c : set){
		if(s2.indexOf(c)!=-1){
			s2 = s2.replaceAll(String.valueOf(c),"");
		}
		
	}*/
		
	/**
	 * loop through the other string and remove the chars
	 * 
	 * IMP: it has flaws
	 */
	for(int i=0;i<s2.length();i++){
		char c = s2.charAt(i);
		if(set.contains(c)){
			s2=s2.replaceAll(String.valueOf(c),"");
		}
	}
			
	
	return s2;
}
	
}
