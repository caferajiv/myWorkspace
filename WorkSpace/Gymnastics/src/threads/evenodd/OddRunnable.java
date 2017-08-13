package threads.evenodd;

public class OddRunnable implements Runnable{

	NumberPrinter np;
	public OddRunnable(){
		
	}
	public OddRunnable(NumberPrinter np){
		this.np=np;
	}
	@Override
	public void run() {

	np.printOdd();
		
	}
	

}
