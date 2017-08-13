package threads.producerconsumer;

public class ConsumerThread implements Runnable{

    Operator opeartor;
	
	public ConsumerThread(){
		
	}
	
	public ConsumerThread(Operator Operator){
		this.opeartor=opeartor;
	}
	@Override
	public void run() {
		
		opeartor.removeCommodityFromList();
		// TODO Auto-generated method stub
		
	}
}
