package patterns.behavioural.strategy.animal;

public class Bird extends Animal {

	Bird(MoveBehaviour moveBehaviour) {
		super(moveBehaviour);
		// TODO Auto-generated constructor stub
	}

	@Override
	void speak() {
		System.out.println("chirp");

	}

	@Override
	void eat() {
		System.out.println("eat grains");

	}
	
	void move() {
		moveBehaviour.move();
	}

}
