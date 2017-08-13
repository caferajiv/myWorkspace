package threads.diningphilosophers;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Fork {
	
	private int id;
	private volatile boolean isTaken;
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock(); 
	ReentrantReadWriteLock.ReadLock readLock = lock.readLock(); 
	ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock(); 
	
	@Override
	public String toString() {
		return "fork";
	}
	
	public Fork(int id)
	{
		this.id=id;
	}

	/**
	 * @return the isTaken
	 */
	public boolean isTaken() {
		try
		{
		 readLock.lock();
		 return isTaken;
		}
		finally{
		readLock.unlock();
		}
		
	}

	/**
	 * @param isTaken the isTaken to set
	 */
	public void setTaken(boolean isTaken) {
		writeLock.lock();
		this.isTaken = isTaken;
		writeLock.unlock();
	}

}
