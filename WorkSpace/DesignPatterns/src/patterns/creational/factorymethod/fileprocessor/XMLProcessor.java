package patterns.creational.factorymethod.fileprocessor;

public class XMLProcessor extends FileProcessor{

	@Override
	public Parser createParser() {
		return new XmlParser();
	}

}
