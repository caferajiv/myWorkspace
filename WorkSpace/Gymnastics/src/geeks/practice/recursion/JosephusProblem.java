package geeks.practice.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class JosephusProblem {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		
		
		for(int i = 0;i <testcases;i++){
			int players = in.nextInt();
			int out = in.nextInt();
			
			int last = josephus(players, out);
			
			System.out.println(last);
		}
		
		
	}
	
	private static int josephus(int n, int k) {
	List<Integer> list = new ArrayList<Integer>();
	for(int j=0;j<n;j++){
		list.add(j+1);
		
	}
		return lastManStanding(list, k,0);
	}

private static int lastManStanding(List<Integer> list, int out, int count) {
	if(list.size()==1 || out ==0 ) return list.get(0);
	
	Iterator<Integer> li =  list.iterator();
	
	while(li.hasNext() && list.size()>1){
		li.next();
		count++;
		if(count==out){
			li.remove();
			count = 0;
		}
	}
	if(list.size()>1){
		//li = null;
		return lastManStanding(list, out, count);
	}else if(list.size()==1){
		return list.get(0);
	}
	
	return -1;

	}


















private static int lastManOut(List<Integer> list, int out) {
		
		ListIterator<Integer> itr = null;
		int index = 0;
		while(list.size()>1){
			itr = list.listIterator();
			
		while(itr.hasNext() && index<out){
			index++;
			Integer val = itr.next();
			if(index==out){
				itr.remove();
				//System.out.println(val);
				index=0;
			}
		}
		itr = null;
		}
		return list.get(0);
	}

}
