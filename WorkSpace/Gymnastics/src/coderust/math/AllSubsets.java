package coderust.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AllSubsets {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		List<HashSet<Integer>> sets = new ArrayList<>();
		System.out.println(get_all_subsets(list,sets));
	}
	
	static List<HashSet<Integer>> get_all_subsets(List<Integer> v, List<HashSet<Integer>> sets) {
		  
		ListIterator<Integer> listItr = v.listIterator();
	    sets.add(new HashSet<Integer>());
	    
	    
	      while(listItr.hasNext()){
	      ListIterator<HashSet<Integer>> setItr = sets.listIterator();
	      Integer val = listItr.next();
	      listItr.remove();
	        while(setItr.hasNext()){
	        	HashSet<Integer> set = new HashSet<>();
	        	set.add(val);
	        	setItr.add(set);
	            setItr.next().add(val);
	        }
	        
	      }
	      
	      return sets;
	    
	  }

}
