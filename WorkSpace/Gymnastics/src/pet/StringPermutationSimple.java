package pet;

public class StringPermutationSimple {
	
	public static void main(String[] args) {
		
		String s = "abc";
		
		
		findPermutations(s);
		
		findPermutations2(s.toCharArray(),s.length());
	}

	private static void findPermutations2(char[] arr, int length) {

		if(length==1)
		{
			System.out.println(arr);
			return;
		}else {
			for(int i=0;i<length;i++) {
				swap(arr,i,length-1);
				findPermutations2(arr,length-1);
				swap(arr,i,length-1);
			}
		}
	}

	private static void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void findPermutations(String s) {
		
		String prefix = "";
		findPermutations(prefix,s);
	}

	private static void findPermutations(String prefix, String s) {

		if(s.length()==0) {
			System.out.println(prefix);
			return;
		}
		else {
			for(int i=0;i<s.length();i++) {
				findPermutations(prefix+s.charAt(i), s.substring(0,i)+s.substring(i+1));;
			}
		}
		
	}

	

}
