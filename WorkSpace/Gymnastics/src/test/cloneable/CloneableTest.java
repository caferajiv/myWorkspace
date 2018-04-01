package test.cloneable;

public class CloneableTest implements Cloneable{
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneableTest test = new CloneableTest();
		CloneableTest clone = (CloneableTest)test.clone();
		
		System.out.println(test);
		System.out.println(clone);
		System.out.println(test == clone);
		System.out.println(test.equals(clone));
		
	}

}
