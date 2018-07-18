package patterns.structural.decorator.beverage;

public class BeverageTester {
	public static void main(String[] args) {
		
		Beverage plainCoffee = new PlainCoffee();
		System.out.println(plainCoffee.getDescription());
		System.out.println(plainCoffee.getCost());
		Beverage cafeLatte = new CafeLatte(plainCoffee);
		System.out.println(cafeLatte.getDescription());
		System.out.println(cafeLatte.getCost());
	}
}
