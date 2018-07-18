package patterns.creational.factorymethod.fileprocessor;

import java.io.File;

public abstract class FileProcessor {
	
	void procesFile(File file) {
		
		Parser parser = createParser();
		parser.parse(file);
		
	}

	public abstract Parser createParser();

}
