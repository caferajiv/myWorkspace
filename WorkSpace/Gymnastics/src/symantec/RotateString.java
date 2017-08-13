package symantec;

import java.util.Arrays;
import java.util.Scanner;

public class RotateString {
	
	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		int res;
		String _A;
		_A = in.nextLine();
		res= minRotate(_A);
		System.out.println(res);
	}

	private static int minRotate(String A) {
		
		char[] charArr = A.toCharArray();
		
		char min = charArr[0];
		for(char a: charArr){
			if(min>a){
				min=a;
			}
			
		}
		return A.indexOf(min);
		
	}

}
