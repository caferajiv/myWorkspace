package pet;

public class StringKPermutation {
	
	public static void main(String[] args) {
		
		char[] arr = {'a', 'b', 'c', 'd'};
		int k = 3;
		
		findPermutation2(arr, k);
		
	}

	private static void findPermutation2(char[] arr, int k) {

		char [] data = new char [k];
		findPermutation2(arr, data, k-1, 0);
		
	}

	private static void findPermutation2(char[] arr, char [] data, int high, int index) {

		for(int i= 0 ;i< arr.length;i++) {
			data[index] = arr[i];
			
			if(index == high) {
				print(data);
			}else {
				findPermutation2(arr, data, high, index+1);
			}
		}
	}

	private static void print(char [] data) {

		System.out.println();
		for(char i : data ) {
			System.out.print(i);
		}
	}

	private static void findPermutation(char[] arr, int n) {

		for (int i = 0;i<arr.length;i++) {
			
			for (int j = 0;j<arr.length;j++) {
				
				for (int k = 0;k<arr.length;k++) {
					System.out.print(arr[i] +""+ arr[j] +""+ arr[k]+ " ");
				}
			}
		}
	}

}
