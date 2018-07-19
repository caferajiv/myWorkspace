package patterns.structural.bridge.filedownload;

import java.io.File;

public class FileDownloader implements FileDownloaderInterface{

	FileDownloadImplementerInterface fileDownloader;
	String path;
	
	public FileDownloader(String path) {
		this.path = path;
	}
	
	@Override
	public File downloadFile() {

		return fileDownloader.download(this.path);
	}

}
