package pet;

import java.util.HashMap;
import java.util.Map;

public class DuplicateChars {
	public static void main(String[] args) {
		String s = "goolge";
		
		System.out.println(removeDuplcateChars(s));
	}

	private static String removeDuplcateChars(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(map.containsKey(s.charAt(i))) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			if(map.get(c)>1) {
				int v = map.get(c);
				map.put(c, --v);
				s = s.substring(0, i)+s.substring(i+1);
			}
		}
		
		return s;
	}

}
