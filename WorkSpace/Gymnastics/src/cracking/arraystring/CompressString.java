package cracking.arraystring;

public class CompressString {
	
	public static void main(String[] args) {
		String str1 = "abc";
		
		System.out.println(compress(str1));
	}

	private static String compress(String str) {
		String compressed = "";
		char lastChar = str.charAt(0);
		int count = 1;
		for(int i=1;i<str.length();i++){
			if(lastChar==str.charAt(i)){
				count++;
			}else{
				compressed = compressed+lastChar;
				if(count>1){
					compressed= compressed+count;
				}
				lastChar=str.charAt(i);
				count=1;
			}
		}
		compressed = compressed+lastChar;
		if(count>1){
			compressed= compressed+count;
		}
		
		return compressed;
	}

}
