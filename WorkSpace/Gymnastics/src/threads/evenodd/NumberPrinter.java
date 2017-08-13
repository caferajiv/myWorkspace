package threads.evenodd;

public class NumberPrinter {

	int number;
	
	public  void printEven()
	{
		while(number<=100)
		{ 
			//try {
			//	wait(500);
			//} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			//}
			synchronized(this){
			if((number%2)==0)
			{
				System.out.print(number+" ");
				number++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notifyAll();
			}else{
				try {
					//Thread.sleep(100);
					wait();
					//notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
			
		}
	}
	
	public  void printOdd()
	{
		while(number<=100)
		{
			//try {
			//	wait(500);
			//} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			//}
			synchronized(this){
			if((number%2)!=0)
			{
			System.out.print(number+" ");
			number++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyAll();
			}else{
				try {
					//Thread.sleep(100);
					wait();
					//notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		
		}
	}
	
	public static void main(String args[]){
		NumberPrinter np= new NumberPrinter();
		np.printEven();
		np.printOdd();
	}
}
