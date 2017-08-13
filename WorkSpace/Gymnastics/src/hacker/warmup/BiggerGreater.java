package hacker.warmup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BiggerGreater {
	
	//private static PrintWriter out = null;
	
	public static void main(String[] args)throws IOException {
		
		/*out = new PrintWriter("D:\\output.txt");
		
		FileReader fr = new FileReader(new File("D:\\manasatestcases.txt"));
		
		BufferedReader br = new BufferedReader(fr);*/
		
		Scanner in = new Scanner(System.in);
   		
		int noOfTestCases = in.nextInt();
		
		String[] strArr= new String[noOfTestCases];
		
		for(int i=0;i<noOfTestCases;i++)
		{
			strArr[i]= in.next();
			//strArr[i]=br.readLine();
		}
		
		for(int i=0;i<noOfTestCases;i++)
		{
			printGreater(strArr[i]);
		}
	}

	private static void printGreater(String string) {
		
		char[] charArray = string.toCharArray();
		int length= string.length();
		
		boolean found=false;
		int index=0;
		for(int i=length-1;i>0;i--){
			if(charArray[i]>charArray[i-1])
			{
				//swap(charArray, i, i-1);
				found=true;
				index=i-1;
				//Arrays.sort(charArray,i-1,length-1);
				//System.out.println(charArray);
				break;
			}
			
		}
		
		if(found==true){
			for(int i=length-1;i>=0;i--){
				if(charArray[i]>charArray[index])
				{
					swap(charArray, i, index);
					
					Arrays.sort(charArray,index+1,length);
					System.out.println(charArray);
					//writeToFile(new String(charArray));
					break;
				}
				
			}
		}
		else
		{
			System.out.println("no answer");
			//writeToFile("no answer");
		}
			
		
	}

	

	private static void swap(char[] charArray, int i, int j) {
		char temp=charArray[i];
		
		charArray[i]=charArray[j];
		charArray[j]= temp;
		
	}

}
