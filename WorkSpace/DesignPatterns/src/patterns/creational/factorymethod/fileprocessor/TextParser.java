package patterns.creational.factorymethod.fileprocessor;

import java.io.File;

public class TextParser implements Parser {

	@Override
	public void parse(File file) {
		System.out.println("Parsing TEXT file");
		
	}

}
