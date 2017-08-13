package pet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	
	public static void main(String[] args) {
		
		String s1 = "camel";
		String s2 = "maecl";
		System.out.println(areAnagrams2(s1,s2));
	}

	private static boolean areAnagrams2(String s1, String s2) {
		if(s1.length()!=s2.length()) return false;
		int length = s1.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0;i<length;i++){
			char c = s1.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}			
		}
		for(int i=0;i<length;i++){
			char c = s2.charAt(i);
			if(!map.containsKey(c)){
				return false;
			}else {
				if(map.get(c)==0)return false;
			}
			map.put(c,map.get(c)-1);
		}
		
		return true;
	}

	private static boolean areAnagrams(String s1, String s2) {
		
		char[] charArr1 = s1.toCharArray();
		char[] charArr2 = s2.toCharArray();
		
		Arrays.sort(charArr1);
		Arrays.sort(charArr2);
		
		String s1new = String.valueOf(charArr1);
		String s2new = String.valueOf(charArr2);
		
		
		if(s1new.equals(s2new)){
			return true;
		}
		
		return false;
	}

}
