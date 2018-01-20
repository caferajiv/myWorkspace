package ocp.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyTests {
	
	public static void main(String[] args) {
		
		//testExecutors();
		testParallelStreams();
		//testCyclicBarriers();
		//testForkJoinRecursiveAction();
		
		testForkJoinRecursiveTask();
		
	}
	
	static class MyRecursiveTask extends RecursiveTask<Integer> {

		int start;
		int end;
		int[] array;
		
		public MyRecursiveTask(int start, int end, int[] arr) {

			this.start = start;
			this.end = end;
			this.array = arr;
			System.out.println("New task created");
		}
		@Override
		protected Integer compute() {
			// base case 
			
			if(end-start<=3) {
				int sum = 0;
				for(int i=start;i<end;i++) {
					array[i] = new Random().nextInt(1000);
					sum = sum +array[i];
				}
				return sum;
				
			}else {
				//recursive case ... spawn new tasks
				int mid = start + (end-start)/2;
				MyRecursiveTask firstTask = new MyRecursiveTask(start, mid, array);
				MyRecursiveTask secondTask = new MyRecursiveTask(mid, end, array);
				firstTask.fork();
				return secondTask.compute() + firstTask.join();
				
			}
			
		}
		
	}

	private static void testForkJoinRecursiveTask() {
		int[] arr = new int[10];
		ForkJoinTask<Integer> task = new MyRecursiveTask(0, 10, arr);
		ForkJoinPool pool = new ForkJoinPool();
		int sum = pool.invoke(task);
		System.out.println("SUM: "+ sum);
		 for(int i:arr) {
			 System.out.print(i + " ");
		 }
		
		
	}

	private static void testForkJoinRecursiveAction() {
		 
		int[] arr = new int[10];
		 ForkJoinTask<?> task = new MyRecursiveAction(0, 10, arr);
		 ForkJoinPool pool = new ForkJoinPool();
		 pool.invoke(task);
		 
		 for(int i:arr) {
			 System.out.print(i + " ");
		 }
		
	}
	
	
	
	static class MyRecursiveAction extends RecursiveAction {
		
		int start;
		int end;
		int[] array;
		
		public MyRecursiveAction(int start, int end, int[] arr) {
			this.start = start;
			this.end = end;
			this.array = arr;
			System.out.println("New task");
		}

		@Override
		protected void compute() {
			//base  case
			if(end-start<=4) {
				//do work
				for(int i=start;i<end;i++) {
					array[i] =  new Random().nextInt(100);
				}
				
			}else {
				//recursive case ...this spawns new threads and does load balancing
				int middle = start + (end-start)/2;
				invokeAll(new MyRecursiveAction(start, middle, array), new MyRecursiveAction(middle, end, array));
			}
			
			
			
			
		}
	
	}

	private static void testCyclicBarriers() {

		CyclicBarrier cb1 = new CyclicBarrier(2,()->System.out.println("First Barrier Broken"));
		CyclicBarrier cb2 = new CyclicBarrier(1,()->System.out.println("Second Barrier Broken"));
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(1);

			for(int i=0;i<3;i++) {
				service .submit(()->performTask(cb1,cb2));
			}
			service.shutdown();
		}finally {

			System.out.println("completed");
			if(service!=null) {
				service.shutdownNow();
			}
			System.out.println("terminated"+service.isTerminated());
		}
	}

	private static String performTask(CyclicBarrier cb1, CyclicBarrier cb2) {
		
		task1();
		try {
			cb1.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task2();
		try {
			cb2.await(2,TimeUnit.MILLISECONDS);
		} catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task3();
		
		return null;
	}

	private static void task3() {
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}

	private static void task2() {
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}

	private static void task1() {
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}

	private static void testParallelStreams() {
		// TODO Auto-generated method stub
		
	}

	private static void testExecutors() {
		ExecutorService service =null;
		try {
		
		service = Executors.newFixedThreadPool(5);
		Future future1 =service.submit(() -> {for(int i=0;i<100;i++) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
			System.out.println(i);
			throw new Exception();
		}return "First Finished";});
		//future1.cancel(true);
		System.out.println(future1.isCancelled());
		System.out.println(future1.isDone());
		
		Future future2 =service.submit(() -> {for(int i=0;i<100;i++) {
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}});
		//future2.get(1,TimeUnit.MILLISECONDS);
		Future future3 = service.submit(() -> {for(int i=0;i<100;i++) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}});
		future3.get();
		
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MICROSECONDS);
		
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			if(service!=null) {
				service.shutdown();
			}
		}
		
		System.out.println("Processors:"+Runtime.getRuntime().availableProcessors());
		
	}

}
