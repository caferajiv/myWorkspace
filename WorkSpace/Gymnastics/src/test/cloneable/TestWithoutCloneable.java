package test.cloneable;

public class TestWithoutCloneable {
	
	
	// does not work and thrwos exception even ater overriding because not an cloneable
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	// will throw a clone not supported exception because class does not implement cloneable
	public static void main(String[] args) throws CloneNotSupportedException {
		TestWithoutCloneable test = new TestWithoutCloneable();
		test.clone();
	}

}
