package pet;

public class StringCombinationSimple {
	
	public static void main(String[] args) {
		
		String s = "abc";
		//findCombinations(s);
		
		findCombinations2(s);
	}

	private static void findCombinations2(String s) {

		String prefix = "";
		findCombinations2(prefix,s);
		
	}

	private static void findCombinations2(String prefix, String s) {

		System.out.println(prefix);
		for(int i=0;i<s.length();i++) {
			findCombinations2(prefix+s.charAt(i), s.substring(i+1));
		}
	}

	private static void findCombinations(String s) {
		String prefix = "";
		findCombinations(prefix ,s);
	}

	private static void findCombinations(String prefix, String s) {

		if(s.length()>0) {
			System.out.println(prefix+s.charAt(0));

			findCombinations(prefix+s.charAt(0), s.substring(1));
			findCombinations(prefix,s.substring(1));
		}
	}

}
