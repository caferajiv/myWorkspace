package patterns.creational.abstractfactory.product;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public ProductA getProductA() {
		return new ConcreteProductA1();
	}

	@Override
	public ProductB getProductB() {
		return new ConcreteProductB1();
	}

}
