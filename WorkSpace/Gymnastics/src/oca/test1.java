package oca;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.lang.NegativeArraySizeException;
import java.lang.Math.*;
import java.lang.NegativeArraySizeException.*;

public class test1 {
	int x =10;
	//static int y = x;
	public static final void main(String[] args) throws Throwable {
		
		int length = args.length;
		System.out.println(length);
		
		Object koala = new Koala();
		CanClimb can = (CanClimb)koala;
		HasClaws hasclaws = (HasClaws)can;
		
		Double doub = new Double(2.0);
		//int[] negativeIndex = new int[-6];
		String s = null;
		s.toString();
		//try {NeagR
			test();
		//}catch(FileNotFoundException e){}
		
		int[] arr = {1,2,3,4,5};
		System.out.println(arr);
		 String[] strarr = {"a", "b", "c"};
		 char[] chararr = new char[3];//{'a', 'b', 'c'};
		 short a =10;
		 short b = 4096;
		 byte by = 127;
		 char c1 = 16;
		 System.out.println(c1);
		 
		// while(false) {
		//	 b++;
		//	 System.out.println(c1);
		// }
		 for (int x = 0;x++<2;) {
			 System.out.println(x);
		 }
		  short c = (short)(a + b);
		System.out.println("class with small letters is allowed in java");
	}
	
	private static void test() {
		System.out.println("testmethod");
	}

}


abstract class AbstractTest {
	abstract void main(); 
}
interface One {
	
	public static void run() throws IOError {
		System.out.println("static run");
	}
}

class MyClass implements One{
	
	public static void run() throws FileNotFoundException {
		System.out.println("class run");
	}
	
}

class MyClassChild extends MyClass {
	public static void run() /*throws IOException*/ {
		System.out.println("Child class static run");
	}
}

interface Two {
	
	public int run();
	
}

interface CanClimb { }
	
interface HasClaws { }

class Koala implements CanClimb, HasClaws {
	
}

//abstract class Fun implements One, Two {}
