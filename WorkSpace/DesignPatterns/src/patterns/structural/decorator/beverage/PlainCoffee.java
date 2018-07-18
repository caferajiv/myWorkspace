package patterns.structural.decorator.beverage;

public class PlainCoffee implements Beverage{

	@Override
	public String getDescription() {
		return "Plain Coffee";
	}

	@Override
	public double getCost() {
		
		return 10.0;
	}

}
