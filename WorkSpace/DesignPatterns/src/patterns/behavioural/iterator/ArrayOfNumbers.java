package patterns.behavioural.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayOfNumbers implements NumberIterator {
	
	private int[] arr = {1,2,3,4,5,6,7,8};

	@Override
	public Iterator createIterator() {
		return Arrays.asList(arr).iterator();
	}

}
