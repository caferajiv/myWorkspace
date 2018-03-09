package pet;

public class ReverseWords {
	public static void main(String[] args) {
		String s = "I am aa very gentle human being.";
		//output : being. human gentle very aa am I
		
		System.out.println(reverseAndRotate(s));
	}

	private static String reverseAndRotate(String s) {

		char[] arr = s.toCharArray();
		reverse(arr,0,arr.length);
		System.out.println(String.valueOf(arr));
		int lastIndex = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==' ') {
				reverse(arr,lastIndex,i);
				lastIndex=i+1;
			}
		}
		return String.valueOf(arr);
	}

	private static void reverse(char[] arr, int low, int high) {
		for(int i=low,j=high-1;i<j;i++,j--) {
			swap(arr,i,j);
		}
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
