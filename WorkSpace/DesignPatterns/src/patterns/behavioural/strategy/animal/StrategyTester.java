package patterns.behavioural.strategy.animal;

public class StrategyTester {
	
	public static void main(String[] args) {
		
		Animal bird = new Bird(new FlyBehaviour());
		bird.eat();
		bird.speak();
		bird.move();
		
		Animal dog = new Dog(new RunBehaviour());
		dog.eat();
		dog.speak();
		dog.move();
		
	}

}
