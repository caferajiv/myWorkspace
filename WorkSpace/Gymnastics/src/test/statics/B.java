package test.statics;

public class B extends A {
	
	/*public static int goThere()
	{
		return 2;
	}*/
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println("instance a "+a.goThere());

		B b = new B();

		System.out.println("instance b "+b.goThere());

		A ab = new B();

		System.out.println("instance ab "+ab.goThere());
		System.out.println("static B "+B.goThere());
		System.out.println("static A "+A.goThere());
		
		final int c=1;
		final short d= 2;
		long l=3;
		float f=5f;
		for(byte i=0;i<5;i++)
		{
			switch(i)
			{
			case 12:
			{
				System.out.println(c);
				break;
			}
			case d:
			{
				
			}
			}
		}
		
		
	}

}
