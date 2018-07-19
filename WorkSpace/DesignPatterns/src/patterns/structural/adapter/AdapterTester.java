package patterns.structural.adapter;

public class AdapterTester {
	
	public static void main(String[] args) {
		
		InterfaceB b = new ConcreteInterfaceB();
		InterfaceB b1 = new InterfaceAAdapter(new  ConcreteInterfaceA());
		
		b.doWork();
		b1.doWork();
		
	}

}
