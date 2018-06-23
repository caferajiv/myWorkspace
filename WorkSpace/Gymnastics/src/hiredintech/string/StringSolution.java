package hiredintech.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSolution {
    
    public static void main(String[] args) {
	
	Scanner in = new Scanner(System.in);

        String string = "there are three bananas on the tree and one banano on the ground";//in.next();
        String word = "banana";//in.next();
	
	//matchPattern(string, regex);
        
        System.out.println(findTypos(string, word));
	
	
    }

    private static int findTypos(String string, String word) {
	int count =0;
	Map<Character, Integer> map = new HashMap<>();
	
	for(int i=0;i<word.length();i++) {
	    char c = word.charAt(i);
	    if(map.containsKey(c)) {
		map.put(c, map.get(c)+1);
	    }else {
		 map.put(word.charAt(i), 1);
	    }
	   
	}
	
	List<String> list  = Arrays.asList(string.split(" "));
	for(String str : list) {
	    if(str.equals(word)) {
		count++;
	    }else if(str.length()==word.length()) {
		int diff = diff(str, map);
		if(diff<=2) {
		    count++;
		}
	    }else if(word.length() == str.length()+1 || word.length() == str.length()-1) {
		int diff = diff(str, map);
		if(diff<=1) {
		    count++;
		}
	    }
	}
	
	return count;
    }

    private static int diff(String str, Map<Character, Integer> map) {
	int diff = Integer.MAX_VALUE;
	for(int i=0;i<str.length();i++) {
	 char c = str.charAt(i);
	 if(map.containsKey(c)) {
	     if(diff==Integer.MAX_VALUE) {
		 diff = 0;
	     }
	     diff++;
	 }
	}
	return Math.abs(diff-map.values().stream().mapToInt(e->e).sum());//map.values().stream().mapToInt(e -> e).reduce(0, (a,b)->Math.abs(a)+Math.abs(b));
    }

    private static void matchPattern(String string, String regex) {
	final Pattern pattern = Pattern.compile("("+regex+")?", Pattern.MULTILINE);
	final Matcher matcher = pattern.matcher(string);

	//matcher.
	while (matcher.find()) {
	    System.out.println("Full match: " + matcher.group(0));
	    for (int i = 1; i <= matcher.groupCount(); i++) {
	        System.out.println("Group " + i + ": " + matcher.group(i));
	    }
	}
    }

}
