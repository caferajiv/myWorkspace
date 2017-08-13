package threads.avgCalc;

public class Marks {

	int i;
	int sum;
	double avg;
	
	public void calculateSum(){
		while(i<=200){
			sum=sum+i;
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void calculateAvg(){
		avg=sum/200;
	}
}
