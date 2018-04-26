package pet;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
	
	public static void main(String[] args) {

		Map<Integer, String> lrucache = new LinkedHashMap<>();
		
		lrucache.put(1,"One");
		lrucache.put(10, "ten");
		lrucache.put(9,"nine");
		lrucache.put(2, "two");
		lrucache.put(5,"five");
		lrucache.put(8, "eight");
		
		System.out.println(lrucache);
		
		if(lrucache.containsKey(2)) {
			String val = lrucache.remove(2);
			lrucache.put(2, val);
			
		}
		
		System.out.println(lrucache);
	}

}
