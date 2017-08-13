package threads.evenodd;

public class EvenRunnable implements Runnable{

	NumberPrinter np;
	public EvenRunnable(){
		
	}
	public EvenRunnable(NumberPrinter np){
		this.np=np;
	}
	@Override
	public void run() {

	np.printEven();
		
	}

}
