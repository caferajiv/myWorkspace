package patterns.behavioural.chainofresponsibility;

public class ChainTester {
	
	public static void main(String[] args) {
		
		Handler addHandler = new AddHandler();
		Handler subHandler = new SubHandler();
		addHandler.setNextHandler(subHandler);
		
		addHandler.handle(1, 2, "sub");
	}

}
