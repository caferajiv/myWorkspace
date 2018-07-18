package patterns.creational.factorymethod.fileprocessor;

import java.io.File;

public class TestFactoryMethod {
	
	public static void main(String[] args) {
		File file = new File("some file");
		FileType type = FileType.XML;
		FileProcessor processor = getFileProcessor(type);
		processor.procesFile(file);
		
	}

	private static FileProcessor getFileProcessor(FileType type) {
		switch(type) {
		case XML : return new XMLProcessor();
		case CSV : return new CsvProcessor();
		case TXT : return new TextProcessor();
		}
		return null;
	}

}
