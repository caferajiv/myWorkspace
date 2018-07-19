package patterns.behavioural.template;

public abstract class Beverage {
	
	boolean sugarNeeded;
	
	public Beverage(boolean sugarNeeded) {
		this.sugarNeeded = sugarNeeded;
	}

	final void makeBeverage() {
		
		boilWater();
		
		addTea();
		
		addCoffee();
		
		if(customerWantsSugar()) {
			addSugar();
		}
		
		brew();
		
		serve();
		
		
	}

	public boolean customerWantsSugar() {
		return sugarNeeded;
	}


	public void boilWater() {
		System.out.println("Boiling water");
		
	}
	public abstract void addCoffee();

	public abstract void addTea();
	
	public abstract void addSugar();

	public abstract void brew();
	
	public void serve() {
		System.out.println("Serving beverage");
		
	}

}
