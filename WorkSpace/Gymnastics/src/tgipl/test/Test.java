package tgipl.test;



class A {void m1(A a) {System.out.print("A");}

class innerA{
	void m1(A a){
		
	}
}
}

class Complex {
    int[] nums = {1,2,3,4,5};
    public Complex clone() {
        return new Complex();
    }
    int[] getNums() {
       return nums;
    }
}
class B extends A {void m1(B b) {System.out.print("B");}}
class C extends B {void m1(C c) {System.out.print("C");}}
public class Test {
	
	public Integer checkType(){
		int i=0;
		return i;
	}
  public static void main(String[] args) {
    A a1 = new A(); B b1 = new B(); C c1 = new C(); A c2 = new C();
    c2.m1(a1); c2.m1(b1); c2.m1(c1);
    //Double d1 = new Double(1.0);
    //Double d2 = new Double(d1);
    //System.out.print(d1.equals(d2));
    String string1="rajiv";
    String string2= new String("rajiv").intern();
    System.out.println(string1.hashCode());
    System.out.println(string2.hashCode());
    System.out.println(string1==string2);
    int first=-5;
    int sec=2;
    int res=first<<sec;
    System.out.println("bit:"+res+":bit");
    Integer a = new Integer(256);
    byte b = a.byteValue();
    char c11='a';
    
    short c = a.shortValue();
    int e = a.intValue();
    long f = a.longValue();
    float g = a.floatValue();
    double h = a.doubleValue();
    System.out.print(b+","+c+","+ (e+f+g+h == 4 * 256));
    
    System.out.println(Long.parseLong("1"));

    Thread t= new Thread(){
    	public void run(){
    		System.out.println("123");
    	}
    };

t.start();

}}



