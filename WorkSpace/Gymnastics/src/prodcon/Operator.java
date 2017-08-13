package prodcon;

import java.util.ArrayList;
import java.util.List;

public class Operator {
	
	private List<String> list = new ArrayList<String>();
	
	public  void consume() throws InterruptedException 
	{
		synchronized(list)
		{
			while(list.size()==0)
			{
				wait();
			}
			
			if(list.size()>0)
			{
				System.out.println(list.remove(0));
			}
		}
	}
	
	public void produce()
	{
		synchronized(list)
		{
			list.add("rajiv");
			notifyAll();
		}
	}

}
