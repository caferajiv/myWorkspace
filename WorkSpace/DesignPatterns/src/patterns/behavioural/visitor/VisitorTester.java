package patterns.behavioural.visitor;

public class VisitorTester {
	
	
	public static void main(String[] args) {
		Milk milk = new Milk(20.00);
		Wine wine = new Wine(299.00);
		Visitor visitor = new TaxVisitor();
		
		double totalPrice = visitor.visit(milk) + visitor.visit(wine);
		
		System.out.println("milk : "+ milk.price);
		System.out.println("wine : "+ wine.price);
		System.out.println("total with tax : "+ totalPrice);
	}
	

}
