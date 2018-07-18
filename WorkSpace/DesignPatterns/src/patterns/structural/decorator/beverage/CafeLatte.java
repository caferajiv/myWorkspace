package patterns.structural.decorator.beverage;

public class CafeLatte implements Beverage{
	
	Beverage coffee;
	
	public CafeLatte(Beverage coffee) {
		this.coffee = coffee;
	}

	@Override
	public String getDescription() {
		
		return coffee.getDescription() + "plus extra Milk";
	}

	@Override
	public double getCost() {
		
		return coffee.getCost() + 5.00;
	}

}
