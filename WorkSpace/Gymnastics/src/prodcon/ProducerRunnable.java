package prodcon;

public class ProducerRunnable implements Runnable{
	
	private Operator op;
	
	ProducerRunnable(Operator op)
	{
		this.op=op;
	}

	@Override
	public void run() {
		op.produce();
		
	}

}
