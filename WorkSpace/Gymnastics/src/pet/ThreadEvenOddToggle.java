package pet;


public class ThreadEvenOddToggle {
	public static void main(String[] args) {
		NumberPrinter sp = new NumberPrinter();
		PrinterTask1 pt1 = new PrinterTask1(sp);
		PrinterTask2 pt2 = new PrinterTask2(sp);
		
		Thread t1 = new Thread(pt1, "ThreadT1");
		Thread t2 = new Thread(pt2, "ThreadT2");
		t1.start();
		t2.start();
		
	}

}

class NumberPrinter {
	
	private int i = 1;
	private boolean b = false;
	
	void PrintT1 () {
		synchronized (this) {
			while(i <=10) {
				if(i%2==0 && b) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println(Thread.currentThread().getName()+": "+i);
					i++;
					b=!b;
					notifyAll();
				}
				
			}
			
		}
		
	}
	
	void PrintT2 () {
		synchronized (this) {
			while(i <=10) {
				if(i%2!=0 && !b) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println(Thread.currentThread().getName()+": "+i);
					i++;
					b=!b;
					notifyAll();
				}
				
			}
			
		}
		
	}
	
}

class NPrinterTask1 implements Runnable
{
	NumberPrinter sp;
	NPrinterTask1 (NumberPrinter sp) {
		this.sp = sp;
	}
	@Override
	public void run() {

		sp.PrintT1();
	}
	
}

class NPrinterTask2 implements Runnable
{
	NumberPrinter sp;
	NPrinterTask2 (NumberPrinter sp) {
		this.sp = sp;
	}

	@Override
	public void run() {

		sp.PrintT2();
	}
	
}








