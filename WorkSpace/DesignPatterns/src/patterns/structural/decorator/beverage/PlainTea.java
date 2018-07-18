package patterns.structural.decorator.beverage;

public class PlainTea implements Beverage{

	@Override
	public String getDescription() {
		
		return "PlainTea";
	}

	@Override
	public double getCost() {
		return 8.00;
	}

}
