package geeks.practice.recursion;

public class StringPermutation2 {
	
	public static void main(String[] args) {
		
		String s = "abcd";
		
		printAllPermutation(s);
		
	}

	private static void printAllPermutation(String s) {
		String str ="";
		permute(s,str);
		
		
		
	}

	private static void permute(String s, String str) {
		
		if(s.length()==0){
			System.out.println(str);
			return;
		}
		char a = s.charAt(0);
		String rem = s.substring(1);
		for(int i=0;i<=str.length();i++){
			String str1 = insertChar(a, str,i);
			permute(rem,str1);
		}
		
	}

	private static String insertChar(char a, String str, int i) {
		
		return str.substring(0,i)+String.valueOf(a)+str.substring(i, str.length());
	}

	

}
