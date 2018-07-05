package coderust.dp;

public class EditDistance {
	
	public static void main(String[] args) {
		String str1 = "kitten";
		String str2 = "sittin";
		System.out.println(levenshtein_distance(str1,str2));
	}
	
	public static int levenshtein_distance(String str1, String str2){
		
		int[][] matrix = new int[str1.length()+1][str2.length()+1];
		matrix[0][0] = 0;
		for(int i=1;i<=str1.length();i++) {
			matrix[i][0] = i; 
		}
		
		for(int j=1;j<=str2.length();j++) {
			matrix[0][j] = j; 
		}
		for(int i=1;i<=str1.length();i++) {
			for(int j =1;j<=str2.length();j++) {
				if(str1.charAt(i-1)== str2.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1];
				}else {
					matrix[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]),matrix[i-1][j-1])+1;
				}
			}
		}
		
      return matrix[str1.length()][str2.length()];
	}

}
