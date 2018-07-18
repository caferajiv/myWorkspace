package patterns.behavioural.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Subject implements Observable {

	List<Observer> observers = new CopyOnWriteArrayList<>();
	
	private String change;
	@Override
	public void register(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void deregister(Observer observer) {

		observers.remove(observer);
	}
	
	
	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
		notifyObserver();
		
	}

	@Override
	public void notifyObserver() {
		for(Observer observer : observers) {
			observer.update(this.change);
		}
		
	}

	
}
