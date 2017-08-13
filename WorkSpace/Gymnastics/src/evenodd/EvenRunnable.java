package evenodd;

public class EvenRunnable implements Runnable{
	
	private NumberPrinter np;
	public EvenRunnable(NumberPrinter np) {
		this.np=np;
	}

	@Override
	public void run() {
		try {
			np.printEven();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
