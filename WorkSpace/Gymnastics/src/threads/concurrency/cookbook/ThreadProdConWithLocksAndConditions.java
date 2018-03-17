package threads.concurrency.cookbook;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import threads.concurrency.cookbook.ThreadProdCon.Consumer;
import threads.concurrency.cookbook.ThreadProdCon.EventStorage;
import threads.concurrency.cookbook.ThreadProdCon.Producer;

public class ThreadProdConWithLocksAndConditions {
	

	
	public static void main(String[] args) {
		EventStorage storage=new EventStorage();	
		Producer producer=new Producer(storage);
		Thread thread1=new Thread(producer);
		
		Consumer consumer=new Consumer(storage);
		Thread thread2=new Thread(consumer);
		
		thread2.start();
		thread1.start();
	}


	static class EventStorage {
		private int maxSize;
		private LinkedList<Date> storage;
		
		private Lock lock = new ReentrantLock();
		private Condition isEmpty = lock.newCondition();
		private Condition isFull = lock.newCondition();
		
		
		public EventStorage(){
			maxSize=10;
			storage=new LinkedList<>();
		}

		public void set(){
			lock.lock();
			try {
				while (storage.size()==maxSize){
					isFull.await();
				}
				storage.offer(new Date());
				System.out.printf("Set: %d",storage.size());
				System.out.println();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				isEmpty.signalAll();
				lock.unlock();
			}

		}


		public void get(){
			lock.lock();
			try {
				while (storage.size()==0){
					isEmpty.await();
				}
				System.out.printf("Get: %d: %s",storage.
						size(),((LinkedList<?>)storage).poll());
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {

				isFull.signalAll();
				lock.unlock();
			}


		}
	}

	static class Producer implements Runnable { 

		private EventStorage storage;
		public Producer(EventStorage storage){
			this.storage=storage;
		}

		@Override
		public void run() {
			for (int i=0; i<100; i++){
				storage.set();
			}
		}
	}

	static class Consumer implements Runnable { 

		private EventStorage storage;
		public Consumer(EventStorage storage){
			this.storage=storage;
		}

		@Override
		public void run() {
			for (int i=0; i<100; i++){
				storage.get();
			}
		}

	}





}
