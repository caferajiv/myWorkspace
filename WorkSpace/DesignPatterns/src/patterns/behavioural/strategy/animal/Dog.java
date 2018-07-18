package patterns.behavioural.strategy.animal;

public class Dog extends Animal {
	
	Dog (MoveBehaviour moveBehaviour) {
		super(moveBehaviour);
	}

	void speak() {
		System.out.println("bark");
		
	}

	void eat() {
		System.out.println("eat pedigree");
		
	}

	void move() {
		moveBehaviour.move();
		
	}

}
