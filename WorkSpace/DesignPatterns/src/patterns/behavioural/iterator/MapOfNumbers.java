package patterns.behavioural.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapOfNumbers implements NumberIterator {

	Map<Integer, Integer> map = new HashMap<>();
	@Override
	public Iterator createIterator() {
		
		return map.values().iterator();
	}

}
