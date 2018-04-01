package test.cloneable;

public class CloneableStack implements Cloneable
{

	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public CloneableStack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	@Override public CloneableStack clone() {
		try {
			CloneableStack result = (CloneableStack) super.clone();
			// separtely clone each mutable element 
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}

	}

}
