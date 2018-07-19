package patterns.behavioural.template;

public class BeverageMaker {
	
	public static void main(String[] args) {
		Beverage beverageTea = new Tea(true);
		beverageTea.makeBeverage();
		
		Beverage coffee = new Coffee(false);
		
		coffee.makeBeverage();
	}

}
