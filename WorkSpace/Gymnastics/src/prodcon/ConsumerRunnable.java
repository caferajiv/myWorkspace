package prodcon;

public class ConsumerRunnable implements Runnable{
	
private Operator op;
	
	ConsumerRunnable(Operator op)
	{
		this.op=op;
	}

	@Override
	public void run() {
		try {
			op.consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
