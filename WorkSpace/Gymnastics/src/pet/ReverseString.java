package pet;

public class ReverseString {

	//rotate abcdefg to cdefgab
	public static void main(String[] args) {
		
		String str = "abcdefg";
		
		String rotatedString = reverseAndRotate(str);
		System.out.println(rotatedString);
		
	}

	private static String reverseAndRotate(String str) {
		
		String rotated1 = rotate(str.substring(0,2));
		String rotated2 = rotate(str.substring(2));
		StringBuilder sb = new StringBuilder(rotated1+rotated2);
		return sb.reverse().toString();
	}

	private static String rotate(String substring) {
		int length = substring.length();
		char[] charArray = substring.toCharArray();
		for(int i=0,j=length-1;i<length && i<=j;i++,j--){
			if(charArray[i]!=charArray[j]){
				swap(charArray, i, j);
			}
		}
		return String.valueOf(charArray);
	}

	private static void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}

	
}
