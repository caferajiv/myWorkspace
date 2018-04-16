package pet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapIterationTest {
	public static void main(String[] args) {
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 1);
		map.put(4, 1);
		map.put(5, 1);
		map.put(6, 1);
		
		System.out.println(map);
	
		Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			map.put(7, 7);
			if(map.size()>6) break;
		}
		
		System.out.println(map);
		
		ConcurrentMap<Set<Integer>,Integer> set = new ConcurrentHashMap<>();
		for(int i=0;i<4;i++) {
			Set<Integer> newset = new HashSet<Integer>();
			newset.add(i+1);
			set.put(newset,1);
		}
		
		
		System.out.println(set.keySet());
	
		Iterator<Set<Integer>> iter1 = set.keySet().iterator();
		int count=0;
		while(iter1.hasNext()) {
			count++;
			Set<Integer> si = iter1.next();
			//if(si.size()>4) break;
			/*iter1.forEachRemaining(new Consumer<Set<Integer>>() {

				@Override
				public void accept(Set<Integer> t) {
					Set<Integer> ss= new HashSet<>();
					for(Iterator<Integer> b = si.iterator();b.hasNext();) {
						ss.add(b.next());
					}
					for(Iterator<Integer> c = t.iterator();c.hasNext();) {
						ss.add(c.next());
					}
					set.put(ss,1);
				}
			});*/
			
			Iterator<Set<Integer>> iter2 = set.keySet().iterator(); 
			for(int i=0;i<count;i++) {
				iter2.next();
			}
			while(iter2.hasNext()) {
				Set<Integer> ss= new HashSet<>();
				Set<Integer> s2 = iter2.next();
				for(Iterator<Integer> b = s2.iterator();b.hasNext();) {
					ss.add(b.next());
				}
				for(Iterator<Integer> c = si.iterator();c.hasNext();) {
					ss.add(c.next());
				}
				set.put(ss,1); 
				
			}
			
		}
		
		System.out.println(set.keySet());
		
		
	}

}
