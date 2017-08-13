package cracking.arraystring;

public class UniqueChars {

	public static void main(String[] args) {
		String str = "abcde";
		System.out.println(isUnique(str));
	}

	private static boolean isUnique(String str) {
		// TODO Auto-generated method stub
		
		boolean[] arr = new boolean[256];
		for(int i=0;i<str.length();i++){
			if(arr[str.charAt(i)]==true){
				return false;
			}
			arr[str.charAt(i)]=true;
		}
		
		return true;
	}
}
