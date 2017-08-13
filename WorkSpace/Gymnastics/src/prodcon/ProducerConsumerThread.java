package prodcon;

public class ProducerConsumerThread {
	
	public static void main(String[] args) {
		Operator op = new Operator();
		Thread prod = new Thread();
		Thread cons = new Thread();
		
		prod.start();
		cons.start();
	}

}
