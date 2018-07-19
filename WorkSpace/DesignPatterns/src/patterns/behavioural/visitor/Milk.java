package patterns.behavioural.visitor;

public class Milk implements Visitable {
	
	double price;
	
	public Milk(double price) {
	this.price = price ;	// TODO Auto-generated constructor stub
	}

	@Override
	public double accept(Visitor visitor) {
		
		return (price * 0)/100 + price;
	}

}
