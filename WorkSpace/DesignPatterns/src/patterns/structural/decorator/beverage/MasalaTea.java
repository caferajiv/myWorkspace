package patterns.structural.decorator.beverage;

public class MasalaTea implements Beverage {

	Beverage tea;
	
	public MasalaTea(Beverage tea) {
		this.tea = tea;
	}
	@Override
	public String getDescription() {
		return tea.getDescription() + " plus Masala";
	}

	@Override
	public double getCost() {
		return tea.getCost() + 5.00;
	}

}
