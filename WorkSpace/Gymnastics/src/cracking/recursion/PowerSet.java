package cracking.recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

public class PowerSet {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6};
		Set<Set<Integer>> powerSet = findPowerSet(arr);
		//System.out.println(powerSet);
		powerSet.stream().sorted((a,b)->a.size()-b.size()).forEach(System.out::println);
		
	}

	private static Set<Set<Integer>> findPowerSet(int[] arr) {
		
		ConcurrentMap<Set<Integer>,Integer> powerMap = new ConcurrentHashMap<>();
		Set<Integer> set = new HashSet<>();
		for(int n: arr) {
			Set<Integer> s = new HashSet<>();
			s.add(n);
			set.add(n);
			powerMap.put(s,1);
		}
		powerMap.put(set,1);
		
		Iterator<Set<Integer>> iter1 = powerMap.keySet().iterator();
		int count=0;
		while(iter1.hasNext()) {
			count++;
			Set<Integer> s1 = iter1.next();
			
			Iterator<Set<Integer>> iter2 = powerMap.keySet().iterator(); 
			for(int i=0;i<count;i++) {
				iter2.next();
			}
			while(iter2.hasNext()) {
				Set<Integer> s2 = iter2.next();
				Set<Integer> newSet= new HashSet<>();
				for(Iterator<Integer> a = s1.iterator();a.hasNext();) {
					newSet.add(a.next());
				}
				for(Iterator<Integer> b = s2.iterator();b.hasNext();) {
					newSet.add(b.next());
				}
				powerMap.put(newSet,1); 
				
			}
		}
		return powerMap.keySet();
	}

}
