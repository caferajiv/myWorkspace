package hacker.warmup;

import java.util.Scanner;

public class MaxXor {
	
	
	static int maxXor(int l, int r) {
		
		int low=0;
		int high=0;
		if(l<r){
			low=l;
			high=r;
		}else if(r<l)
		{
			low=r;
			high=l;
		}else
		{
		   return l^r;
		}
		
		int maxXor=0;
		for(int i=low;i<=high;i++)
		{
			for(int j=i;j<=high;j++)
			{
		       if(maxXor<(i^j)){
		    	   maxXor=i^j;
		       }		
			}
		}
		return maxXor;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }

}
