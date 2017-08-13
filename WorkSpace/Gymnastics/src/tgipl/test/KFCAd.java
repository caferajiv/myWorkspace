package tgipl.test;

public class KFCAd {

	
	public static void main(String[] args) {
		int N=3;
		int M=2;
		int K=1;
		int mod=1000000007;
		
		System.out.println(min_boards(N,M,K));
		
		
	}
	
	public static int min_boards(int n, int m, int k) {
		int mod=1000000007;
		/*int batch_size=m;
		int ads_to_consider= n-2;
		//since batch will be treated as one so ads left
		int left_ads = ads_to_consider - batch_size;
		//considering batch as 1
		int effective_combs= left_ads+1;
		
		int combination = findCombination(m, k);
		int total_combs= effective_combs*combination;
		//System.out.println(combination);
		return total_combs%mod;*/
		
		//find out how many distinct groups can be formed.
		if(m==k) return 1;
		int gp = n/m;
		int overlapping_groups = 0;
		if(n%m==0)
		{
			overlapping_groups=0;
		}else
		{
			if(gp>1)
			{
				//overlapping_groups=n-(gp*m);
				int n_new = (n-gp*m)+m;
				return (gp-1)*findCombination(m, k)+ min_boards(n_new,m,k);
			}
			else
			{
				overlapping_groups=m-(n-(gp*m));
			}
		}
		
		if(overlapping_groups==0)
		{
			return gp*findCombination(m, k);
		}
		if(overlapping_groups>k)
		{
			return findCombination(overlapping_groups, k);
		}
		if(overlapping_groups==k)
		{
			return 1;
		}
		if(overlapping_groups<k)
		{
			int k_new = k-overlapping_groups;
			int m_new = m-overlapping_groups;
			int n_new = n-overlapping_groups;
			return findCombination(m_new, k_new)*(n_new/m_new);
			
		}
		
		
		return 0;
		
	}

	private static int findCombination(int n , int r)
	{
		return factorial(n)/(factorial(n-r)*factorial(r));
	}

	private static int factorial(int n) {
		int product=1;
		for (int i=1;i<=n;i++)
		{
			product=product*i;
		}
		return product;
		
	}
}
