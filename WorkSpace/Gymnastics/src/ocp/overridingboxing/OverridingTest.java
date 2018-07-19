package ocp.overridingboxing;

public class OverridingTest {
	
	public static void main(String[] args) {
	
		int[] arr = {1,2,3};
		for(var i: arr) {
			System.out.println(i);
		}
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
