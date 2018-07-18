package patterns.behavioural.strategy.animal;

public abstract class Animal {
	
	String species;
	
	MoveBehaviour moveBehaviour;
	
	Animal(MoveBehaviour moveBehaviour){
		this.moveBehaviour = moveBehaviour;
	}
	
	abstract void speak();
	
	abstract void eat();
	
	void  move() {
		moveBehaviour.move();
	};
	

}
