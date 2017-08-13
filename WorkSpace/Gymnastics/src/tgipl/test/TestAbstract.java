package tgipl.test;

public abstract class TestAbstract {
	
	public final native void test();
	
	public static void main(String args[])
	{
		System.out.println(4>>>4);
		/* This is the start of a comment
		if (true) {
		Test5 = new test5();
		System.out.println("Done the test");
		}
		/* This is another comment */
		System.out.println ("The end");
		
		byte b = 10;
        method(b);
        
        /* // */
        
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(true);
        boolean b3 = true;
        Boolean b4 = true;
        System.out.println(b1==b2);
        System.out.println(b1==b3);
        System.out.println(b3 == b4);
        System.out.println(b1 == b4);



		
	}
	
	static void method(int i){
        System.out.println("Primitivae Type call");
    }
    static void method(Integer i){
        System.out.println("Wrapper Type Call");
    }


}
