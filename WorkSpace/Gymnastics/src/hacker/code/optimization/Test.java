package hacker.code.optimization;

public class Test {
	
	
	static int collatzSequenceLen(int n) {
		
		int[] arr = new int[3*n+2];
		arr[0] = 0;
		arr[1] = 1;
		
        for(int i=2;i<=3*n+1;i++) {
        	if (i % 2 == 0) {
                arr[i] = 1 + arr[(i/2)];
            }
        }
        
        for(int i=3;i<=3*n+1;i++) {
        	if (i % 2 != 0) {
                arr[i] = 1 + arr[(3*i+1)];
            }
        }
        
        return arr[n];
    }

    static int collatzSequenceSum(int T, int A, int B) {
        int n = 0;
        int result = 0;
        while (T-- > 0) {
            n = (A*n + B) % 5003;
            int best_len = 0;
            int best_num = 0;
            for (int k = 0; k <= n; ++k) {
                int cur_len = collatzSequenceLen(k);
                if (cur_len >= best_len) {
                    best_len = cur_len;
                    best_num = k;
                }
            }
            result += best_num;
        }
        return result;
    }

}
