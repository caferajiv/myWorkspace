package patterns.creational.abstractfactory.product;

public class FactoryTest {
	public static void main(String[] args) {
		
		String type1 = "1";
		String type2 = "2";
		AbstractFactory factory = getFactory(type2);
		System.out.println(factory.getProductB());
		
	}

	private static AbstractFactory getFactory(String type) {
		switch(type) {
		case "1" : return new ConcreteFactory1();
		case "2" : return new ConcreteFactory2();
		}
		return null;
	}

}
