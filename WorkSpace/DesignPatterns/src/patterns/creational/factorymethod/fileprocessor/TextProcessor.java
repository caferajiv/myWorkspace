package patterns.creational.factorymethod.fileprocessor;

public class TextProcessor extends FileProcessor{

	@Override
	public Parser createParser() {
		return new TextParser();
	}

}
