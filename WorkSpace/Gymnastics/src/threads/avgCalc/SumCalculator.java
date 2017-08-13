package threads.avgCalc;

public class SumCalculator implements Runnable {

	Marks marks;
	public SumCalculator(){
		
	}
	public SumCalculator(Marks marks){
		this.marks=marks;
	}
	@Override
	public void run() {
		
		marks.calculateSum();
		
	}

}
