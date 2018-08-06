package ocp.overridingboxing;

import java.util.*;
public class OverridingTest {
	
	public static void main(String[] args) {
	
		double[] arr = new double[10000];
		for(var i: arr) {
			//System.out.println(i);
		}
		try {
		throw new OutOfMemoryError();
		}catch(Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("caught OOM");
	}
	
	static class A {
	
		Number methodA(){
			return 4;
		}
		
	}
	
	static class childA extends A {
		
		Integer methodA() {
			
			return 5;
		}
		
	}

}
