package patterns.structural.adapter;

import java.util.concurrent.ExecutorService;

public abstract class ExecutorServiceAdapter implements AutoCloseable{

	private final ExecutorService service;
	
	public ExecutorServiceAdapter(ExecutorService service) {
		this.service = service;
	}
	
	@Override
	public void close() throws Exception {
		service.shutdown();
	}

}
