package cracking.arraystring;

public class CheckAnagram {
	
	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "bdcea";
		
		System.out.println(isAnagram(str1,str2));
		
	}

	private static boolean isAnagram(String str1, String str2) {
		if(str1.length()!=str2.length()){
			return false;
		}
		int[] charCount = new int[256];
		for(int i=0;i<str1.length();i++){
			charCount[str1.charAt(i)] = charCount[str1.charAt(i)]+1;
		}
		
		for(int i=0;i<str2.length();i++){
			charCount[str2.charAt(i)] = charCount[str2.charAt(i)]-1;
		}
		
		for(int n : charCount){
			if(n!=0){
				return false;
			}
		}
		return true;
	}

}
