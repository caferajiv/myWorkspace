package ocp.whiz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class Test {
	
	int age;
	
	public boolean stAge(int ae) throws IllegalArgumentException {
		if(ae<18 || ae >80) {
			throw new IllegalArgumentException();
		}else {
			age = ae;
			return true;
		}
	}
	
	
	     public static void main(String[] args) {
	          try (FileReader fs = new FileReader("F:\\ocp\\input.txt")) {
	               System.setOut(new PrintStream("F:\\ocp\\output.txt"));
	               System.out.print((char)fs.read());
	          } catch (Exception ex) {
	               System.err.print("Error reading file");
	          }
	     }

}
