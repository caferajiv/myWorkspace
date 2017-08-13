package hacker.algo.warmup;

import java.util.Scanner;

public class TimeConversion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 String time = in.next();
		 String[] arr = time.split(":");
		 String lastBit = arr[arr.length-1];
		 if(lastBit.endsWith("PM") && !arr[0].equals("12")){
			 int hour = Integer.parseInt(arr[0]);
			 hour = hour+12;
			 arr[0] = String.valueOf(hour);
		 }
		 else if(lastBit.endsWith("AM") && arr[0].equals("12")){
			 arr[0] = "00";
		 }
		 for(int i=0;i<arr.length;i++){
			 if(i==arr.length-1){
				 System.out.print(arr[i].substring(0, 2));
			 }else{
				 System.out.print(arr[i]+":");
			 }
			 
		 }
	}

}
