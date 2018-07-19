package patterns.behavioural.chainofresponsibility;

public class AddHandler implements Handler{

	private Handler nextHandler;
	@Override
	public void setNextHandler(Handler handler) {
		nextHandler = handler;
		
	}

	@Override
	public void handle(int a, int b, String op) {
		if(op.equals("add")) {
			System.out.println(a+b);
		}else {
			if(nextHandler!=null) {
				nextHandler.handle(a, b, op);
			}else {
				System.out.println("Handler not defined");
			}
		}

	}

}
