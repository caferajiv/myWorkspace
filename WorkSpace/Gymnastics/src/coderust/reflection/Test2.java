package coderust.reflection;

import java.lang.reflect.InvocationTargetException;

class Dispatcher {

	String methodName;
	
	public Dispatcher(String name) {
		methodName = name;
	}
	
	Object dispatch (Object param) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.getClass().getDeclaredMethod(methodName, param.getClass()).invoke(this, param.getClass().cast(param));
		return param;
	}
	
}
public class Test2 extends Dispatcher{
	
	public Test2() {
		
		super("test");
		
	}
	
	Object test(Object par) {
		
		System.out.println("Object");
		return par;
	}
	
	Object test(String par) {
		
		System.out.println("String");
		return par;
	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		new Test2().dispatch("a string..");
		new Test2().dispatch(new Object());
	}

}
