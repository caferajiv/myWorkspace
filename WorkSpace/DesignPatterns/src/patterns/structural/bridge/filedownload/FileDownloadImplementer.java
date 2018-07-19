package patterns.structural.bridge.filedownload;

import java.io.File;

public class FileDownloadImplementer implements FileDownloadImplementerInterface{

	@Override
	public File download(String path) {
		
		return new File(path);
	}

}
