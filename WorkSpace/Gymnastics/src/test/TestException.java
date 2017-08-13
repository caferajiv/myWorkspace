package test;

public class TestException {
	
	public static void main(String args[])
	 {
		
		test();
	 }
	
	public static void test(){
		
		 System.out.println(Math.floor(-4.7));
		System.out.println(Math.round(-4.7));
		 System.out.println(Math.ceil(-4.7));
		// System.out.println(Math.min(-4.7)); 

		 System.out.println("A");
		 try
		 {
		 return;
		 }
		 catch(Exception e)
		 {
		 System.out.println("B");
		 }
		 System.out.println("C");
		 
	}
	

}
