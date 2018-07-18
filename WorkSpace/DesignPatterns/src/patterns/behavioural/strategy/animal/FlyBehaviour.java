package patterns.behavioural.strategy.animal;

public class FlyBehaviour implements MoveBehaviour{

	@Override
	public void move() {
		System.out.println("Flying");
		
	}

}
