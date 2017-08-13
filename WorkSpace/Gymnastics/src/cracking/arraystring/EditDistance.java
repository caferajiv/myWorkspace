package cracking.arraystring;

public class EditDistance {
	
	public static void main(String[] args) {
		String str1 = "aoole";
		String str2 = "aole";
		
		System.out.println(isEditDistanceOne(str1,str2));
	}

	private static boolean isEditDistanceOne(String str1, String str2) {
		
		if(Math.abs(str1.length()-str2.length())>1){
			return false;
		}
		int length1 = str1.length();
		int length2 = str2.length();
		int index1=0;
		int index2=0;
		
		String first=null;
		String second = null;
				
		if(length1>length2){
			first = str1;
			second = str2;
			
		}else{
			first = str2;
			second = str1;
		}
		
		boolean foundDifference = false;
		while(index1 < first.length() && index2 <second.length()){
			if(first.charAt(index1)!=second.charAt(index2)){
				if(index1==index2){
					if(foundDifference == true){
						return false;
					}else{
						foundDifference = true;
					}
					if(length1!=length2){
						index2--;
					}
				}else{
					return false;
				}
				
				
			}
			index1++;
			index2++;
		}
		
	return true;	
	}

}
