package tgipl.test;

import java.util.Arrays;



public class TestSetPartition {
	
	public static void main(String[] args) {
		int arr[]={};
		
		System.out.println(setpartition(arr));
		
	}
	
	private static boolean setpartition(int []a)
	{
		if(a.length==0) return false;
		int sum = findSum(a);
		if(sum%2!=0)
			return false;
		
		return findPartition(a,sum/2);
		
		//return false;
	}

	private static boolean findPartition(int[] a, int half) {
		
		Arrays.sort(a);
		int length= a.length;
		if(a[length-1]>half)
			return false;
		int sum=0;
		//sum=a[length-1];
		while(length>0)
		{
			if((sum+a[length-1])<=half)
			{
				sum=sum+a[length-1];
				if(sum==half)return true;
			}
			else
			{
				break;
			}
			length--;
		}
		int i=0;
		
		while(i<a.length)
		{
			if((sum+a[i])<=half)
			{
				sum=sum+a[i];
				if(sum==half)return true;
			}
			else
			{
				break;
			}
		}
		
		return false;
	}

	private static int findSum(int[] a) {
		int sum=0;
		for(int i : a)
			sum=sum+i;
		return sum;
	}
	


}
