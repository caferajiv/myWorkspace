package test.cloneable;


/**
 * 
 * Final word on cloneable
 * Given all the problems associated with Cloneable, new interfaces should
	not extend it, and new extendable classes should not implement it. While it’s less
	harmful for final classes to implement Cloneable, this should be viewed as a
	performance optimization, reserved for the rare cases where it is justified (Item
	67). As a rule, copy functionality is best provided by constructors or factories. A
	notable exception to this rule is arrays, which are best copied with the clone
	method.
 * 
 * From Effective java third edition
 * @author Rajiv
 *
 */

public class CloneableHashtable implements Cloneable {
	private Entry[] buckets;
	private static class Entry {
		final Object key;
		Object value;
		Entry next;
		Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		/*Entry deepCopy() {
			return new Entry(key, value, next == null ? null : next.deepCopy());
			} */

		// Iteratively copy the linked list headed by this Entry  more efficient
		Entry deepCopy() {
			Entry result = new Entry(key, value, next);
			for (Entry p = result; p.next != null; p = p.next)
				p.next = new Entry(p.next.key, p.next.value, p.next.next);
			return result;
		}


	}
	
	// Broken clone implemnettation does not deepcpy all the entries in the bukets
	/*@Override public CloneableHashtable clone() {
		try {
			CloneableHashtable result = (CloneableHashtable) super.clone();
			result.buckets = buckets.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}}
	*/
	
	//Proper clone method 
	@Override public CloneableHashtable clone() {
		try {
			CloneableHashtable result = (CloneableHashtable) super.clone();
			result.buckets = new Entry[buckets.length];
			for (int i = 0; i < buckets.length; i++)
				if (buckets[i] != null)
					result.buckets[i] = buckets[i].deepCopy();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}

	}
		
		
}
