package patterns.creational.abstractfactory.product;

public class ConcreteFactory2 extends AbstractFactory {

	@Override
	public ProductA getProductA() {
		return new ConcreteProductA2();
	}

	@Override
	public ProductB getProductB() {
		return new ConcreteProductB2();
	}

}
