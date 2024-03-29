package threads.concurrency.cookbook;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

	public static void main(String[] args) {
		SafeTask task=new SafeTask();
		for (int i=0; i<10; i++){
			Thread thread=new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class UnsafeTask implements Runnable{
		private Date startDate;
		@Override
		public void run() {
			startDate=new Date();
			System.out.printf("Starting Thread: %s : %s\n",Thread.
					currentThread().getId(),startDate);
			try {
				TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Thread Finished: %s : %s\n",Thread.
					currentThread().getId(),startDate);
		}
	}

	static class SafeTask implements Runnable {
		private static ThreadLocal<Date> startDate= new
				ThreadLocal<Date>() {
			protected Date initialValue(){
				return new Date();
			}
		};

		@Override
		public void run() {
			System.out.printf("Starting Thread: %s : %s\n",Thread.
					currentThread().getId(),startDate.get());
			try {
				TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Thread Finished: %s : %s\n",Thread.
					currentThread().getId(),startDate.get());
		}

	}
}
