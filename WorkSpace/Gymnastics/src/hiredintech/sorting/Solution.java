package hiredintech.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    
    public static void main(String[] args) {
	
	List<String> result = new ArrayList<>();
	//sort_the_files(16, result);
	//System.out.println(result);
	int n = 5;
	int t = 65;
	List<Integer> tasks = Arrays.asList(24, 23, 22, 10, 20);
	
	System.out.println(maximum_completed_tasks(n,t,tasks));
	
    }
    
    public static void sort_the_files(int n, List<String> result) {
        if(n<=0) return;
       
        PriorityQueue<String> max_Heap = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(int i=1;i<=n;i++) {
            String fileName = "IMG"+i+".jpg";
            if(max_Heap.size()>1000 && fileName.compareTo(max_Heap.peek())<0) {
        	max_Heap.poll();
            }
            max_Heap.offer(fileName);
           
        }
        result.addAll(max_Heap);
        Collections.sort(result);
        
        for(String s : result) {
            System.out.println(s);
        }
        
    }
    
    
    public static int maximum_completed_tasks(int n, int t, List<Integer> task_difficulties) {
       int count = 0;
       Collections.sort(task_difficulties);
       int previous_task = 0;
       int waiting_time = 0;
       if(t<task_difficulties.get(0)) return 0;
       for(int task : task_difficulties) {
	   if(previous_task>0) {
	       waiting_time = Math.abs(task - previous_task);
	   } 
	   if( t >= (task + waiting_time)) {
	       t = t - (task + waiting_time);
	       count++;
	       previous_task = task;
	   }else {
	       break;
	   }
	   
       }
       
       return count;
    }

}
