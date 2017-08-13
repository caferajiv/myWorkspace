package tgipl.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Bird {
	  { System.out.print("b1 "); }
	  public Bird() { System.out.print("b2 "); }
	  
	  public Object get(){return null;};
	}
	class Raptor extends Bird {
	  static { System.out.print("r1 "); }
	  public Raptor() { System.out.print("r2 "); 
	  
	  return;}
	  { System.out.print("r3 "); }
	  static { System.out.print("r4 "); }
	  
	  public String get(){return null;};
	}
	//class Hawk extends Raptor {
//	  public static void main(String[] args) {
//	    System.out.print("pre ");
//	    new Hawk();
//	    System.out.println("hawk ");
//	  }
//	}


public class TestGenerics extends Raptor{

	
	public static void main(String[] args) {
	    System.out.print("pre ");
	    new TestGenerics();
	    System.out.println("hawk ");
	    
	    short s = 7;
	    System.out.print(doX(s,s) + " ");
	    System.out.println(doX(7,7));
	    
	   ArrayList<Integer> sampleList = new ArrayList<Integer>(); 
	    sampleList.add(40); 
	  sampleList.add(20); 
	   sampleList.add(70); 
	   for(int num : sampleList) 
	  System.out.println(num); 

			   Collection<? extends String> c = new ArrayList<String>();
			  
	    Thread t = new Thread();
	    System.out.println("daemon: "+t.isDaemon());
	    t.setDaemon(true);
	    System.out.println("daemon: "+t.isDaemon());
			   System.out.println(0.0==-0.0); 
	  }
	
	static int doX(Long x, Long y) { return 1; }
	static int doX(long... x) { return 2; }
	static  int doX(Integer x, Integer y) { return 3; }
	static  int doX(Number n, Number m) { return 4; }

}
