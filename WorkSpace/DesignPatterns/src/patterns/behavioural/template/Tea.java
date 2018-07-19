package patterns.behavioural.template;

public class Tea extends Beverage {

	public Tea(boolean sugarNeeded) {
		super(sugarNeeded);
	}
	@Override
	public void brew() {
		System.out.println("Brewing for 2 min");

	}

	@Override
	public void addSugar() {
		System.out.println("Add 2 sugar cubes");

	}

	@Override
	public void addCoffee() {
		
	}

	@Override
	public void addTea() {
		System.out.println("Add tea leaves");

	}

}
