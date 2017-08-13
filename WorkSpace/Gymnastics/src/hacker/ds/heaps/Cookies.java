package hacker.ds.heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Cookies {
	
	public static void main(String[] args) {
		 PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		 Scanner in = new Scanner(System.in);
		 int cookies = in.nextInt();
		 int sweetness = in.nextInt();
		 
		 for(int i=0;i<cookies;i++){
			 heap.add(in.nextInt());
		 }
		 int count=0;
		 if(heap.isEmpty()){
			 System.out.println(-1);
			 return;
		 }
		 while(!heap.isEmpty() && heap.peek()<sweetness && heap.size()>1){
			 int leastSweet = heap.remove();
			 int secondSweet = heap.remove();
			 int newCookie = leastSweet + (2*secondSweet);
			 heap.add(newCookie);
			 count++;
		 }
		if(heap.peek()<sweetness){
			System.out.println(-1);
			return;
		}
		 System.out.println(count);
	}

}
