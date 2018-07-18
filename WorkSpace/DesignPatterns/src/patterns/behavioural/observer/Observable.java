package patterns.behavioural.observer;

public interface Observable {
	void register(Observer observer);
	void deregister(Observer observer);
	void notifyObserver();

}
