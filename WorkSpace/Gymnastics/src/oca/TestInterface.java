package oca;

public interface TestInterface {
	
	static void testingStatic() {
		System.out.println("static method");
	}
	
	public String toString();
	
	default void testingDefault() {
		System.out.println("default method");
	}

}
