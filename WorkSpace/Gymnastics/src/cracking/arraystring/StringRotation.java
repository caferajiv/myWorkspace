package cracking.arraystring;

public class StringRotation {
	
	public static void main(String[] args) {
		String str = "ttlewaterbo";
		
		System.out.println(isRotated(str));
	}

	private static boolean isRotated(String str) {
		// TODO Auto-generated method stub
		String newStr = new StringBuilder(str).append(str).toString();
		if(newStr.indexOf(str)!=-1){
			return true;
		}
		return false;
	}

}
