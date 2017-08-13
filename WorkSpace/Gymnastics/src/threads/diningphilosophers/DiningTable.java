package threads.diningphilosophers;

public class DiningTable {
	
	private static Philosopher[] philosophers= new Philosopher[5];
	private static Fork[] forks = new Fork[5];
	
	
	public static void main(String[] args) {
		initializePhilosophers();
		for(int i=0;i<5;i++)
		{
			Thread thread = new Thread(philosophers[i]);
			thread.start();
		}
	}
	
	private static void initializePhilosophers()
	{
		initializeForks();
		
		for(int i=0; i<5;i++)
		{
			if(i==0)
			{
				philosophers[i]= new Philosopher(i+1, forks[i], forks[4]);	
				philosophers[i].setOdd(true);
			}
			else
			{
				philosophers[i]= new Philosopher(i+1, forks[i], forks[i-1]);
				if(!((i+1)%2==0))
				{
					philosophers[i].setOdd(true);
				}
			}
			
		}
	}
	
	private static void initializeForks()
	{
		for(int i=0; i<5;i++)
		{
			forks[i]= new Fork(i+1);
		}
	}

}
