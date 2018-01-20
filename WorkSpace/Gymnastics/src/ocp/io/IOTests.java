package ocp.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;

public class IOTests {
	
	static class SerializableClass implements Serializable {
		String name;
		static String surname;
		int height;
		transient int weight;
		Job job;
		
		transient Object someObject;
		
		public SerializableClass() {
			
			name = "bobby";
			surname = "khan";
			height = 10;
			weight = 60;
			this.job = new Job("SE", 123456);
			this.someObject = new Object();
		}
		
		@Override
		public String toString() {
			String s = name + surname + height + weight;
			if(job!=null) {
				s = s + job.designation + job.salary;
			}
			if(someObject!=null) {
				 s = s  + someObject.toString();
			}
			return s;
		}
		
	} 
	
	static class Job implements Serializable {
		String designation;
		int salary;
		
		public Job(String s, int sal) {
			designation = s;
			salary = sal;
		}
	}
	
	
	public static void main(String[] args) {
		
		//fileStreamTest();
		//bufferedWriterTest();
		printStreamTest();
		printWriterTest();
		consoleTest();
		//markSkipTest();
		//serializationTest();
		//fileActionsTest();
	}
	
	private static void serializationTest() {
		SerializableClass sss = new SerializableClass();
		System.out.println(sss);
		File file = new File("F:\\ocp1\\serial.txt");
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));) {
			os.writeObject(sss);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
		SerializableClass sc = (SerializableClass)ois.readObject();
		System.out.println(sc);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private static void fileStreamTest() {
		File read = new File("F:\\ocp1\\test.txt");
		File write = new File("F:\\ocp1\\test2.txt");
		
		try(FileInputStream fis = new FileInputStream(read);
				FileOutputStream fos = new FileOutputStream(write,true)) {
			
			while(fis.available()>0) {
				fos.write((char)fis.read());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void bufferedWriterTest() {
		File read = new File("F:\\ocp1\\test.txt");
		File write = new File("F:\\ocp1\\test2.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(read));
				BufferedWriter bw = new BufferedWriter(new FileWriter(write,true))) {
			String s=null;
			while((s = br.readLine())!=null) {
				bw.write(s);
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printStreamTest() {
		// TODO Auto-generated method stub
		
	}

	private static void printWriterTest() {
		// TODO Auto-generated method stub
		
	}

	private static void consoleTest() {

		Console con = System.console();
		System.out.println(con);
		if(con!=null) {
			con.format("My Stribng ", null);
			String input = con.readLine();
			//con.printf(input, input);
			con.writer().println(input);
			con.readPassword();
		}
	}

	private static void markSkipTest() {
		File write = new File("F:\\ocp1\\test2.txt");
		// Not supporrted for FileInputStream
		try(BufferedInputStream fis = new BufferedInputStream(new FileInputStream(write));){ 
			System.out.print((char)fis.read());
			System.out.println(fis.markSupported());
			if(fis.markSupported()) {
				fis.mark(3);
				System.out.print((char)fis.read());
				System.out.print((char)fis.read());
				fis.reset();
				System.out.print((char)fis.read());
				System.out.print((char)fis.read());
				System.out.print((char)fis.read());
				System.out.print((char)fis.read());
				System.out.print((char)fis.read());
				System.out.print((char)fis.read());
				fis.reset();
				System.out.print((char)fis.read());
				System.out.print((char)fis.read());
			}
			
			System.out.print((char)fis.read());
			System.out.print((char)fis.read());
			System.out.print((char)fis.read());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// Not supporrted for FileInputStream
		try(BufferedInputStream fis = new BufferedInputStream(new FileInputStream(write));){ 
			System.out.println("skip tests");
			System.out.print((char)fis.read());
			fis.skip(2);
			System.out.print((char)fis.read());
			System.out.print((char)fis.read());
			System.out.print((char)fis.read());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	

	private static void fileActionsTest() {
		
		File read = new File("F:\\ocp1\\test.txt");
		File write = new File("F:\\ocp1\\test2.txt");
		
		try(FileInputStream fis = new FileInputStream(read);
				FileOutputStream fos = new FileOutputStream(write,true)) {
			System.out.println("read.exists():"+read.exists());
			System.out.println("abs path :"+read.getAbsolutePath());
			System.out.println(read.canWrite());
			System.out.println(read.getCanonicalPath());
			System.out.println(read.isDirectory());
			System.out.println(read.isFile());
			System.out.println(read.getParentFile().isDirectory());
			System.out.println(Instant.ofEpochMilli(write.lastModified()));
			
			System.out.println("stream");
			//Stream.of(read.getParentFile().list()).collect(()-> new StringBuilder(), s-> {sb.append(s); return sb;});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
