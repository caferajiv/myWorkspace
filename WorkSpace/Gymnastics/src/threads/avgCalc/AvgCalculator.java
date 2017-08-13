package threads.avgCalc;

public class AvgCalculator implements Runnable{
	
	Marks marks;
	SumCalculator sumCalculator;
	public AvgCalculator(){
		
	}
	public AvgCalculator(Marks marks,SumCalculator sumCalculator){
		this.marks=marks;
		this.sumCalculator=sumCalculator;
	}
	@Override
	public void run() {
		Thread t= new Thread(sumCalculator);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		marks.calculateAvg();
		
	}

}
