package pet;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class KickdrumTest {
	
	public static void main(String[] args) {
		
	}
	
	/*
     * Complete the findMaximumEvents function below.
     */
    static void findMaximumEvents(String[] eventDetails) {
        String[] in_out_times = new String[eventDetails.length*2];
        int index = 0;
        final int IN = 1;
        final int OUT = -1;
        Map<Integer,Integer> map = new TreeMap<>();
        Stack<String> stack = new Stack<>();
        //Arrays.sort(eventDetails);
        for(String eventTime: eventDetails){
            if(eventTime!=null && eventTime.length()>0){
                 String[] tokens = eventTime.trim().split(" ");
                 if(tokens.length>1){
                     int in_time = Integer.parseInt(tokens[0]);
                     int out_time = Integer.parseInt(tokens[1]);
                     
                     in_out_times[index++] = in_time+"I";
                     in_out_times[index++] = out_time+"O";
                     //if(!map.containsKey(in_time) || map.get(in_time)!=OUT)
                     //map.put(in_time,IN);
                     //in_out_times[index++] = out_time;
                     //if(!map.containsKey(out_time) || map.get(out_time)!=IN)
                     //map.put(out_time,OUT);
                 }
            }
           
        }
        
        Arrays.sort(in_out_times);
        int count = 0;
        for(String time : in_out_times){
            if(stack.isEmpty() && time.endsWith("I")){
                stack.push(time);
                count++;
            }else if(!stack.isEmpty() && time.endsWith("O")){
                stack.pop();
            }
        }
        
        System.out.println(count);

    }


}
