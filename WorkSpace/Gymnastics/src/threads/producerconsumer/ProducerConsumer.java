package threads.producerconsumer;

import java.util.ArrayList;

public class ProducerConsumer {

	public static void main(String args[]){
		Operator operator=new Operator(new ArrayList<Commodity>());
		Thread producer= new Thread(new ProducerThread(operator));
		Thread consumer= new Thread(new ConsumerThread(operator));
		producer.start();
		consumer.start();
		
	}
}
