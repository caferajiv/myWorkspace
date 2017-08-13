package coding;

public class TrailingZeroes {
	
	private static int counter=0;
	 
	public static void main(String[] args) {
		/*int n=16;
		long f[]= new long[n+1];
		factorial(n,f);
		for(int i=0; i<f.length;i++)
		{
			System.out.println(f[i]);
		}
		System.out.println("trailing zeroes"+counter);*/
		
		trailingZeroes(25);
	}
	
	private static long factorial(int n, long[] f)
	{
		if(n==0 || n==1)
		{ if (f[n]==0)
			f[n]=1;
		return 1;
		}
		else
		{ if(n%5==0) counter++;
			if(f[n]==0)
				f[n]=n*factorial(n-1,f);
			return f[n];
		}
		
	}
	
	private static void trailingZeroes(int num)
	{
		int count=0;
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
			}
		
		System.out.println("Trail zeroes:"+ count);
	}
	
	public int countEvens(int[] nums) {
		  int count =0;
		  for(int i=0; i < nums.length; i++)
		  {
			  if(nums[i]%2==0)count++;
		  }
		  return count;
		}
	
		
		
	
}
