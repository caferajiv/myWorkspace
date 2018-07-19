package patterns.behavioural.iterator;

import java.util.Iterator;
import java.util.List;

public class ListOfNumbers implements NumberIterator {
	
	List<Integer> list = List.of(1,2,3,4,5,6,7,8);

	@Override
	public Iterator createIterator() {
		return list.iterator();
	}
	

}
