package geeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllNumbersfromSet {
	
	public static void main(String[] args) {
		
		int [] set = {1,2,3,4};
		int k = 2;
		List list = new ArrayList();
		
		printAllKNumbers(set,list, set.length ,k);
	}

	private static void printAllKNumbers(int[] set, List list, int n, int k) {
		
		if(k==0){
			for(Object i:list){
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++){
			 list.add(set[i]);
			 List newList = new ArrayList(list);
			 
			 printAllKNumbers(set,newList,n,k-1);
		}
		
	}

	
}
