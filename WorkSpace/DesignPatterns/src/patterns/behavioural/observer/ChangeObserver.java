package patterns.behavioural.observer;

public class ChangeObserver implements Observer {

	private Observable subject;
	
	public ChangeObserver(Observable subject) {
		this.subject = subject;
		this.subject.register(this);
	} 
	
	private String data;
	@Override
	public void update(String data) {
		this.data = data;
		
		System.out.println("Data updated");
		
	}

}
