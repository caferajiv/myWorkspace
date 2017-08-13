package threads.diningphilosophers;


public class Philosopher implements Runnable{
	
	private int id;
	private boolean isOdd;
	private Fork leftFork;
	private Fork rightFork;
	
	Philosopher(int id, Fork leftFork, Fork rightFork)
	{
		this.id=id;
		this.leftFork=leftFork;
		this.rightFork=rightFork;
	}
	

	@Override
	public void run() {
		while(true)
		{
		if (isOdd) {
			if (!leftFork.isTaken()) {
				synchronized (leftFork) {
					leftFork.setTaken(true);
					if (!rightFork.isTaken()) {
						synchronized (rightFork) {
							rightFork.setTaken(true);
							eat();
							rightFork.setTaken(false);
							notifyAll();
						}
					}
					leftFork.setTaken(false);
					notifyAll();

				}
			}
			

		} else {
			if (!rightFork.isTaken()) {
				synchronized (rightFork) {
					rightFork.setTaken(true);
					if (!leftFork.isTaken()) {
						synchronized (leftFork) {
							leftFork.setTaken(true);
							eat();
							leftFork.setTaken(false);
							notifyAll();
						}
					}
					rightFork.setTaken(false);
					notifyAll();

				}
			}
			

		}
		think();
		}

	}
	
	public void eat()
	{
		System.out.println(this.toString()+"Started Eating");
		int rand= getARandomNumberToWait();
		try {
			Thread.sleep(rand*this.id*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.toString()+"Finished Eating");
	}
	
	private int getARandomNumberToWait() {
		return 1 + (int)(Math.random() * ((5 - 1) + 1));
		
	}


	public void think()
	{
		System.out.println(this.toString()+"Started Thinking");
		int rand= getARandomNumberToWait();
		try {
			Thread.sleep(rand*this.id*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.toString()+"Finished Thinking");
	}
	
	@Override
	public String toString() {
		return "Philosopher"+this.id;
	}


	/**
	 * @return the isOdd
	 */
	public boolean isOdd() {
		return isOdd;
	}


	/**
	 * @param isOdd the isOdd to set
	 */
	public void setOdd(boolean isOdd) {
		this.isOdd = isOdd;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the leftFork
	 */
	public Fork getLeftFork() {
		return leftFork;
	}


	/**
	 * @return the rightFork
	 */
	public Fork getRightFork() {
		return rightFork;
	}
	

}
