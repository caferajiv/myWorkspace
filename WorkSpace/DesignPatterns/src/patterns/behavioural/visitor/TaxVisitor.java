package patterns.behavioural.visitor;

public class TaxVisitor implements Visitor {

	@Override
	public double visit(Visitable visitable) {
		return visitable.accept(this);
		
	}

}
