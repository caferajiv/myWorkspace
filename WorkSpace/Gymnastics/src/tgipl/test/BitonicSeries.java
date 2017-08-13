package tgipl.test;

import java.util.ArrayList;
import java.util.List;

public class BitonicSeries {
	
	public static void main(String[] args) {
		int []arr={80, 60, 30, 40, 20, 10};
		System.out.println(bitonic(arr));
	}
	
	public static int bitonic(int[] arr) {
		int[] LISnew = new int[arr.length];
		int[] LDSnew = new int[arr.length];
		int n=arr.length;
		for ( int i = 1; i < n; i++ )
		      for ( int j = 0; j < i; j++ )
		         if ( arr[i] > arr[j] && LISnew[i] < LISnew[j] + 1)
		        	 LISnew[i] = LISnew[j] + 1;
		
		for ( int i = n-2; i >= 0; i-- )
		      for ( int j = n-1; j > i; j-- )
		         if ( arr[i] > arr[j] && LDSnew[i] < LDSnew[j] + 1)
		        	 LDSnew[i] = LDSnew[j] + 1;
		
		int max = LISnew[0] + LDSnew[0] + 1;
		   for (int i = 1; i < n; i++)
		     if (LISnew[i] + LDSnew[i] + 1 > max)
		         max = LISnew[i] + LDSnew[i] + 1;
		   
		   return max;
	}
	

	public static int bitonic_sequence(int[] arr) {
		
		int[] LIS = new int[arr.length];
		int[] LDS = new int[arr.length];
		int[] LISnew = new int[arr.length];
		int[] LDSnew = new int[arr.length];
		int n=arr.length;
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j] && LIS[i]<LIS[j]+1)
				{
					LIS[i]=LIS[j]+1;
				}
				else if(arr[i]<arr[j] && LDS[i]<LDS[j]+1)
				{
					LDS[i]=LDS[j]+1;
				}
			}
		}
		
		List<Integer> LISUnique= new ArrayList<Integer>();
		List<Integer> LDSUnique= new ArrayList<Integer>();
		for(int k: LIS)
		{
			if(LISUnique.size()!=0)
			{
				if(k==LISUnique.get(LISUnique.size()-1))
				{
					//LISUnique.add(LISUnique.size()-1,k);
					continue;
				}
				
			}
			
			LISUnique.add(k);
		}
		
		for(int k: LDS)
		{

			if (LDSUnique != null && LDSUnique.size() != 0) {
				if (k == LDSUnique.get(LDSUnique.size() - 1)) {
					// LDSUnique.add(LDSUnique.size()-1,k);
					continue;
				}

			}

			LDSUnique.add(k);

		}
		List<Integer> finalList=null;
		if(LISUnique.size()>LDSUnique.size())
		{
			finalList = LISUnique;
		}
		else
		{
			finalList = LDSUnique;
		}
		
		return checkMaxValInList(finalList);
		
		
	}

	private static int checkMaxValInList(List<Integer> finalList) {

		int max=0;
		int index=0;
		for(int i=0;i < finalList.size();i++)
		{
			if(finalList.get(i)>max)
			{
				max=finalList.get(i);
				index=i;
			}
		}
		if(index==finalList.size()-1)
		{
			return max+1;
		}
		return max+1+2;
	}

}
