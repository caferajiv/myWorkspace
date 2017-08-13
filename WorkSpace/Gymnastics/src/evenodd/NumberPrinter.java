package evenodd;

public class NumberPrinter {
	
	private int i=1;

	public synchronized void printEven() throws InterruptedException
	{
		for(;i<=100 ;i++)
		{
			while(i%2!=0) 
			{
				wait();
			}
				
			if(i<=100)
			{
			System.out.print(i+" ");
			}
			notifyAll();
		}
	}
	
	public synchronized void printOdd()throws InterruptedException
	{
		for(;i<=100 ;i++)
		{
			while(i%2==0) 
		    {
				wait();
		    }
			if(i<=100)
			{
				System.out.print(i+" ");
			}
			notifyAll();
		}
	}
}
