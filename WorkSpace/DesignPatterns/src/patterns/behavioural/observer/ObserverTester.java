package patterns.behavioural.observer;

public class ObserverTester {
	
	public static void main(String[] args) {
		
		Subject subject = new Subject();
		Observer dataObserver  = new ChangeObserver(subject);
		
		subject.setChange("Changes");
		subject.deregister(dataObserver);
		subject.setChange("Changed again");
	}

}
