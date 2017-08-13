package pet;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String input1 = "ABCBDAB";
		String input2 = "BDCABA";
		int len1 = input1.length();
		int len2 = input2.length();
		int index1=0;
		int index2=0;
		int indexLCS = 0;
		char[] LCS = new char[10];
		int length = LCSLength(input1, index1, len1,input2,index2,len2,LCS, indexLCS);
		
		//newWay(input1, len1, input2,len2);
		
		System.out.println(length);
	}

	private static int LCSLength(String input1,int index1, int len1, String input2, int index2,
			int len2,char[] LCS, int indexLCS) {
		if(index1==len1 || index2 == len2){
			System.out.println(LCS);
			LCS = null;
			LCS = new char[10];
			return 0;
			
		}
			
		
		if(input1.charAt(index1)==input2.charAt(index2)){
			LCS[indexLCS]=input1.charAt(index1);
			indexLCS++;
			return 1+ LCSLength(input1, index1+1, len1, input2, index2+1, len2,LCS,indexLCS);
		}else {
			int x = LCSLength(input1, index1+1, len1, input2, index2, len2,LCS ,indexLCS);
			int y = LCSLength(input1, index1, len1, input2, index2+1, len2,LCS, indexLCS);
			
			if(x>=y){
				LCS[indexLCS]=input1.charAt(index1);
			}else{
				LCS[indexLCS]=input2.charAt(index2);
			}
			indexLCS++;
			return (Math.max(x,y));
		}
		
	}
	
	private static void newWay(String x , int M, String y, int N){
		// opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();
	}
}
