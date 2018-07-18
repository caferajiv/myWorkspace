package patterns.creational.factorymethod.fileprocessor;

public class CsvProcessor extends FileProcessor{

	@Override
	public Parser createParser() {
		
		return new CsvParser();
	}

}
