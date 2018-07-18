package coderust.string;

public class PalindromeSubstrings {
	
	public static void main(String[] args) {
		System.out.println(find_all_palindrome_substrings("aabbbaa"));
	}
	
	public static int find_all_palindrome_substrings(String input) {
	    int l = input.length();
		for(int i=0;i<input.length();i++) {
			for(int j=i-1,k=i+1;j>=-1 && k<input.length();) {
				//j--;
				//k++;
				if(j<0)j=0;
				if(k>=l)k=l-1;
				char J = input.charAt(j);
				char K = input.charAt(k);
				if(J == K) {
					System.out.println(input.substring(j, k+1));
					j--;
					k++;
				}else {
					break;
				}
			}
		}
	        return -1;
	  }

}
