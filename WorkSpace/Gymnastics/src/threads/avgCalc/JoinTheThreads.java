package threads.avgCalc;

public class JoinTheThreads {
	
	public static void main(String args[]){
		Marks marks=new Marks();
		SumCalculator sumCalculator= new SumCalculator(marks);
		AvgCalculator avgCalculator= new AvgCalculator(marks, sumCalculator);
		Thread sumCalc= new Thread(sumCalculator);
		Thread avgCalc= new Thread(avgCalculator);
		sumCalc.start();
		avgCalc.start();
	}

}
