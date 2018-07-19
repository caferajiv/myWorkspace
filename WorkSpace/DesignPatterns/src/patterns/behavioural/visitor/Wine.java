package patterns.behavioural.visitor;

public class Wine implements Visitable {
	
	double price;
	
	public Wine(double price) {
		this.price = price;
	}

	@Override
	public double accept(Visitor visitor) {
		return (price * 20)/100 + price;
	}

}
