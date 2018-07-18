package patterns.creational.builder.animalbuilder;

public class Animal {

	private String name;
	public String getName() {
		return name;
	}
	public String getSpecies() {
		return species;
	}
	private String species;
	
	Animal(String name, String species){
		this.name  = name;
		this.species = species;
		
	}
}
