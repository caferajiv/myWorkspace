package hackerearth.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RR {
	
	public static void main(String args[] ) throws Exception {
        /*
         *Read input from stdin and provide input before running
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        
        String[] arr= new String[testCases];
        for (int i = 0; i < testCases; i++) {
        	arr[i]=br.readLine();
        }
        

        for (int i = 0; i < testCases; i++) {
        	System.out.println(findNoOfRs(arr[i]));
        }
       
    }

	private static int findNoOfRs(String string) {
		int globalCountR=0;
		int countR=0;
		
		int countK=0;
		int strLength= string.length();
		//boolean flag = false;
		int gainArr[] = new int[strLength];
		int maxGainArr[] = new int[strLength];
	
		/*if(string.indexOf("K")<0){
			return string.length()-1;
		}*/
		//int startIndex=0;
		//int endIndex=0;
		
		for(int i=0;i<strLength;i++)
		{
			/*if(i==strLength-1 && string.charAt(i)=='R'){
				gainArr[i]=1;
				globalCountR++;
				continue;
			} */
			if(string.charAt(i)=='R'){
				countR++;
				gainArr[i]=-1;
				globalCountR++;
			}else if(string.charAt(i)=='K'){
				gainArr[i]=1;
				countK++;
				//endIndex=i;
			}
			
			
			/*if(countR>=countK){
				
				countR=0;
				if(string.charAt(i)=='R'){
					countK=0;
					//startIndex=i+1;
				}else{
					countK=1;
					//startIndex=i;
				}
				
			}*/
		}
		
		int max=gainArr[0];
		maxGainArr[0]=gainArr[0];
		for(int i=1;i<strLength;i++){
			maxGainArr[i]=Math.max(gainArr[i],gainArr[i]+maxGainArr[i-1]);
			max=Math.max(max, maxGainArr[i]);		
		}
		
		
		return (globalCountR+max);
	}

}
