package threads.producerconsumer;

public class ProducerThread implements Runnable {

	
	Operator opeartor;
	
	public ProducerThread(){
		
	}
	
	public ProducerThread(Operator Operator){
		this.opeartor=opeartor;
	}
	@Override
	public void run() {
		
		opeartor.addCommodityToList(new Commodity());
		// TODO Auto-generated method stub
		
	}

}
