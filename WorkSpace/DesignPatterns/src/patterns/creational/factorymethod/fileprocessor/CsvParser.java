package patterns.creational.factorymethod.fileprocessor;

import java.io.File;

public class CsvParser implements Parser {

	@Override
	public void parse(File file) {
		System.out.println("Parsing CSV file");
		
	}

}
