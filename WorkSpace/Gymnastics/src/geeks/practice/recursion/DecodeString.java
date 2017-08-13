package geeks.practice.recursion;

import java.util.Scanner;
import java.util.Stack;
import java.util.zip.InflaterOutputStream;

import javafx.scene.input.InputMethodTextRun;

public class DecodeString {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 String[] inputArray = new String[testcases];
		 for(int i=0;i<testcases;i++){
			 String print= "";
			 
			decodeString(in.next(),print);
		  }
		 
	
	

}

	private static void decodeString(String inputStr, String print) {
		
		while(inputStr.indexOf('[')!=-1){
		int length = inputStr.length();
		int index = inputStr.lastIndexOf('[');
		int index2 = getIndexOfClosingBracket(inputStr,index, length);
		String str = inputStr.substring(index+1,index2);
		int x = findX(inputStr, index);
		int index3 = getIndexOfDigit(inputStr, index);
		str = repeatXTimes(str, x);
		inputStr = inputStr.substring(0,index3+1)+str+inputStr.substring(index2+1);
		}
		System.out.println(inputStr );
		
		
		
	}

	private static int getIndexOfDigit(String inputStr, int index) {

		int j = index-1;
				
		if(Character.isDigit(inputStr.charAt(j))){
			while(j>=0 && Character.isDigit(inputStr.charAt(j))){
				j--;
			}
		}
		return j;
	}

	private static int getIndexOfClosingBracket(String inputStr, int index, int length) {
		int i = index;
		String str = "";
		while(i<length-1){
			if(inputStr.charAt(++i)==']'){
				return i;
			}
			
		}
		return i;
	}

	private static int findX(String inputStr, int index) {
		int j = index-1;
		int x = 1;
		int count = 0;
		
		if(Character.isDigit(inputStr.charAt(j))){
			x =0;
			while(j>=0 && Character.isDigit(inputStr.charAt(j))){
				x = x + (inputStr.charAt(j)-'0') * (int)Math.pow(10,count);
				count++;
				j--;
			}
		}
		return x;
	}

	private static String repeatXTimes(String str, int x) {
		StringBuilder sb = new StringBuilder();
		while(x>0){
			sb.append(str);
			x--;
		}
		return sb.toString();
	}
	
}
