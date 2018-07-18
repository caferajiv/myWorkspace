package patterns.creational.singleton;

import java.io.Serializable;

public class SingletonPattern implements Cloneable, Serializable{
	
	private SingletonPattern () {
		if(instance != null) {
			throw new RuntimeException("cannot create object second time");
		}
		System.out.println("Created");
	}
	
	private static volatile SingletonPattern instance;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	private Object readResolve() {
		return instance;
	}
	
	public static SingletonPattern getInstance() {
		if(instance == null) {
			synchronized (SingletonPattern.class) {
				if(instance == null) {
					instance = new SingletonPattern();
				}
			}
		}
		return instance;
	}
	
	static class Holder 
	{
	  public static SingletonPattern instance = new SingletonPattern();
	}
	
	public static void main(String[] args) {
		
		SingletonPattern singleton = SingletonPattern.Holder.instance;
	}

}
