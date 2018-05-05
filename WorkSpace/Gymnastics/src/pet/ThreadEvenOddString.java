package pet;

public class ThreadEvenOddString {
	public static void main(String[] args) {
		StringPrinter sp = new StringPrinter();
		PrinterTask1 pt1 = new PrinterTask1(sp);
		PrinterTask2 pt2 = new PrinterTask2(sp);
		
		Thread t1 = new Thread(pt1, "ThreadT1");
		Thread t2 = new Thread(pt2, "ThreadT2");
		t1.start();
		t2.start();
		
	}

}

class StringPrinter {
	private String s = "abcdefghijklmnopqrstuvwxyz";
	private int i = 0;
	
	void PrintT1 () {
		synchronized (this) {
			while(i < s.length()) {
				if(i%2!=0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println(Thread.currentThread().getName()+": "+s.charAt(i));
					i++;
					notifyAll();
				}
				
			}
			
		}
		
	}
	
	void PrintT2 () {
		synchronized (this) {
			while(i < s.length()) {
				if(i%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println(Thread.currentThread().getName()+": "+s.charAt(i));
					i++;
					notifyAll();
				}
				
			}
			
		}
		
	}
	
}

class PrinterTask1 implements Runnable
{
	StringPrinter sp;
	PrinterTask1 (StringPrinter sp) {
		this.sp = sp;
	}
	@Override
	public void run() {

		sp.PrintT1();
	}
	
}

class PrinterTask2 implements Runnable
{
	StringPrinter sp;
	PrinterTask2 (StringPrinter sp) {
		this.sp = sp;
	}

	@Override
	public void run() {

		sp.PrintT2();
	}
	
}








