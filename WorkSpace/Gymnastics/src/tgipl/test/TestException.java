package tgipl.test;

import java.io.File;
import java.io.IOException;

public class TestException extends Object{
	
	public TestException(){}
	
	public static void main(String args[]){
		
		System.out.println(fileCreateTest());
		
		for(char i='A';i<'z';i++)
		{
			System.out.println((int)i);
		}
	}
	
	public static int fileCreateTest(){
		try{
			File file = new File("D://rajiv.txt");
			file.createNewFile();
			
			if(!file.createNewFile())
			{
			throw new Exception();
			}
			
		}catch(IOException ioe){
			System.out.println("IO caught");
			
		}catch(Exception e){
			System.out.println("Exception caught");
		}
		finally{
			System.out.println("Finally");
			return 3;
		}
		
		
	} 

}
