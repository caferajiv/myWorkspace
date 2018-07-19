package patterns.behavioural.chainofresponsibility;

public interface Handler {
	
	void setNextHandler(Handler handler);
	
	void handle(int a , int b, String op);

}
