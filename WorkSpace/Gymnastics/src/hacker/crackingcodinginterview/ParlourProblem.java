package hacker.crackingcodinginterview;

import java.util.Arrays;
import java.util.Scanner;

public class ParlourProblem {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int trips = sc.nextInt();
		
		for(int i=0;i<trips;i++) {
			int money = sc.nextInt();
			int length = sc.nextInt();
			int[] arr = new int[length];
			int[] copyarr = new int[length];
			for(int j=0;j<length;j++) {
				arr[j] = sc.nextInt();
				copyarr[j] = arr[j];
			}
			
			findIndexes(arr,copyarr,money);
			
		}
		
	
	}

	private static void findIndexes(int[] arr, int[] copyarr, int money) {
		
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		while(i<arr.length-1 && j>0) {
			if(arr[i]+arr[j]==money) {
				int index1 =  find(copyarr,arr[i],-1);
				int index2 =  find(copyarr,arr[j],index1);
				System.out.println(index1+1+" "+(index2+1));
				return;
			}else if(arr[i]+arr[j]<money) i++;
			else if(arr[i]+arr[j]>money) j--;
			
		}
		
	}

	private static int find(int[] arr, int a, int index) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==a) { 
				if(index!=-1 && i==index) continue;
				return i;
				
			}
		}
		return -1;
		
		
	}

}
