package patterns.creational.builder.animalbuilder;

public class AnimalBuilder {

	private String species;
	private String name;
	AnimalBuilder setSpecies(String species) {
		this.species = species;
		return  this;
	}
	
	AnimalBuilder setName (String name) {
		this.name = name;
		return this;
	}
	
	Animal build() {
		return new Animal(name, species);
	}
	
}
