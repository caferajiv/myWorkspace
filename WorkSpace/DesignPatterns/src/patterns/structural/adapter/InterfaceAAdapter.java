package patterns.structural.adapter;

public class InterfaceAAdapter implements InterfaceB {

	InterfaceA adaptee;
	
	public InterfaceAAdapter(InterfaceA adaptee) {
		this.adaptee  = adaptee;
	}
	@Override
	public void doWork() {
		adaptee.execute();
		
	}

}
