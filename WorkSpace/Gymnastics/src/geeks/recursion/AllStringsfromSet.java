package geeks.recursion;

public class AllStringsfromSet {
	
	public static void main(String args[]){
		
		char[] set = {'a', 'b'};
		int k = 3;
		
		printAllStrings(set,3);
		
	}

	private static void printAllStrings(char[] set, int k) {
		
		int len = set.length;
		
		printAllKlength(set, "", len , k);
		
		
	}

	private static void printAllKlength(char[] set, String string, int len, int k) {
		if(k==0){
			System.out.println(string);
			return;
		}
		
		for(int i=0;i<len;i++){
			String string1 = string+set[i];
			printAllKlength(set, string1, len, k-1);
		}
		
		
		
	}

}
