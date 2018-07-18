package patterns.behavioural.strategy.animal;

public class RunBehaviour implements MoveBehaviour{

	@Override
	public void move() {
		System.out.println("Running");
		
	}

}
