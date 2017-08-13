package coding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StringPermutation {
	
	/*private static List<String> permList= new ArrayList<String>();
	private static List<String> copyPermList= new ArrayList<String>();*/
	public static void main(String args[])
	{
		String s ="abc";
		char emptychar='\\';
		
		//permuteWithSwapping(s.toCharArray(),s.length());
		
		System.out.println(permute(s));
		
		
		/*
		 * permutations of abc= {abc, acb, bac, bca, cab, cba}
		 */
	}
	
	private static void permuteWithSwapping(char []a, int n)
	{
		if(n==1)
		{
			System.out.println(a);
			return;
		}
		
		for(int i=0;i<n;i++)
		{
			swap(a, i ,n-1);
			permuteWithSwapping(a,n-1);
			swap(a,i,n-1);
		}
	}
	
	private static void swap(char []arr, int i , int j)
	{
		char temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
	}

	private static List<String> permute(String s)
	{
		List<String> permList = new ArrayList<String>();
		if(s.length()>1)
		{
			for (int i=0;i<s.length();i++ )
			{
				char c = s.charAt(i);
				String remainder =s.replace(c+"", "");
				List<String> words = permute(remainder);
				for( String word : words)
				{
					permList.add(c+word);
				}
			}
		}
		else
		{
			permList.add(s);
			return permList ;	
		}
		return permList;
		
	}
	
	
	
	public static List<String> permuteWithInserting(String s)
	{
		List<String> perm = new ArrayList<String>();
		if(s==null)
			return null;
		else if(s.length()==0)
		{
			perm.add("");
			return perm;
		}
		char first= s.charAt(0);
		String remainder = s.substring(1);
		List<String> words = permuteWithInserting(remainder);
		for(String word : words)
		{
			for (int j=0;j<=word.length();j++)
			{
				perm.add(insertCharAt(word,j,first));
			}
		}
		return perm;
	}

	private static String insertCharAt(String word, int i, char c) {
		String start = word.substring(0,i);
		String end= word.substring(i);
		return start + c + end;
	}
	
}
