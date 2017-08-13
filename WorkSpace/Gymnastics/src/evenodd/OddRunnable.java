package evenodd;

public class OddRunnable implements Runnable {

	private NumberPrinter np;
	public OddRunnable(NumberPrinter np) {
		this.np=np;
	}

	@Override
	public void run() {
		try {
			np.printOdd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
