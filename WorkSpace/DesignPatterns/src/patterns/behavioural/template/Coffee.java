package patterns.behavioural.template;

public class Coffee extends Beverage {
	
	public Coffee(boolean sugarNeeded) {
		super(sugarNeeded);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void brew() {
		System.out.println("Brewing for 1 min");

	}

	@Override
	public void addSugar() {
		System.out.println("Add 1 cube sugar");

	}

	@Override
	public void addCoffee() {
		System.out.println("Add instant coffee powder");

	}

	@Override
	public void addTea() {

	}

}
