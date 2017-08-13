package hackerearth.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class PromNight {
	
	public static void main(String args[] ) throws Exception {
        /*
         *Read input from stdin and provide input before running
         */
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int testCases = Integer.parseInt(line);
        
        String[] result= new String[testCases];
        int boys=0;
        int girls=0;
        for (int i = 0; i < testCases; i++) {
        	//try using readline
        	boys=br.read();
        	girls=br.read();
        	
        	int[] boyArr = new int [boys];
            int[] girlArr = new int [girls];
            for(int j=0;j<boys;j++){
            	boyArr[j]= br.read();
            }

            for(int k=0;k<girls;k++){
            	girlArr[k]= br.read();
            }
            
            result[i] = checkPairingStatus(boyArr,girlArr);
        	
        }
        
        for(int i=0;i<testCases;i++){
        	System.out.println(result[i]);
        }
        
       
       
    }

	private static String checkPairingStatus(int[] boyArr, int[] girlArr) {
		// TODO Auto-generated method stub
		String status = "YES";
		int boysLength= boyArr.length;
		int girlsLength = girlArr.length;
		if(boysLength>girlsLength) return "NO";
		
		Arrays.sort(boyArr);
		Arrays.sort(girlArr);
		
		for(int i=0,j=0;i<boysLength&&j<girlsLength;){
			if(boyArr[i]<girlArr[i]) return "NO";
		}
		
		return status;
	}

}
