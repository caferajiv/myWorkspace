package ocp.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExceptionsTest {
	
	public static void main(String[] args) {
		
		//testTryWithResources();
		
		//testTryWithMyResourceChecked();
		
		testTryWithMyResourceUnChecked();
		
	}

	private static void testTryWithMyResourceUnChecked() {

		try {

			try(MyResourceUnChecked res1 = new MyResourceUnChecked(1);
					MyResourceUnChecked res2 = new MyResourceUnChecked(2)){
				throw new NullPointerException("Nulley ho kya!!");
			}finally {
				throw new NullPointerException("Nulley ho kya yarron!!");
			}
		}/*catch(Exception e) {
			System.out.println("Primary: "+e.getMessage());
			for(Throwable t : e.getSuppressed()) {
				System.out.println("Suppressed: "+t.getMessage());
			}

		}*/finally {
			throw new IllegalStateException("Illegal state");
		}

	}
	
	
	private static void testTryWithMyResourceChecked() {

		try(MyResourceChecked res1 = new MyResourceChecked(1);
			MyResourceChecked res2 = new MyResourceChecked(2)){
			//throw new NullPointerException("Nulley ho kya!!");
		} catch (Exception e) {
			System.out.println("Primary: "+e.getMessage());
			for(Throwable t : e.getSuppressed()) {
				System.out.println("Suppressed: "+t.getMessage());
			}
		}
	}

	private static void testTryWithResources() {

		Path path = Paths.get("F:\\WorkSpace\\DesignPatterns\\src\\patterns\\creational\\factorymethod\\ProductFactory.java"); //F:\ocp\nio\test
		
		try(FileInputStream fis = new FileInputStream(path.toFile())){
			throw new NullPointerException("JLT");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
	}
	
	
	static class MyResourceChecked implements AutoCloseable{

		int id;
		public MyResourceChecked(int id) {
			this.id = id;
		}
		@Override
		public void close() throws Exception {
			throw new Exception("Exception while closing MyResource:"+id);
			
		}
		
	} 
	
	static class MyResourceUnChecked implements AutoCloseable{

		int id;
		public MyResourceUnChecked(int id) {
			this.id = id;
		}
		@Override
		public void close() {
			throw new RuntimeException("RuntimeException while closing MyResource:"+id);
			
		}
		
	} 

}
