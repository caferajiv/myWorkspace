package patterns.behavioural.visitor;

public interface Visitable {
	
	double accept(Visitor visitor);

}
