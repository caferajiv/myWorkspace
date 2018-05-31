package patterns.creational.singleton;

public class Singleton {
	
	private Singleton() {}

	/**
	 * The inner class is referenced no earlier 
	 * (and therefore loaded no earlier by the class loader) 
	 * than the moment that getInstance() is called.
	 * Thus, this solution is thread-safe without requiring 
	 * special language constructs (i.e. volatile or synchronized).
	 * @author Rajiv
	 *
	 */
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
}
