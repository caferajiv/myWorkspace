package geeks.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MaxTip {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		int[] maxOrders = new int[testcases];
		int[] x = new int[testcases];
		int[] y = new int[testcases];
		
		for(int i=0;i<testcases;i++) {
			maxOrders[i] = in.nextInt();
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			
			int[] xArr = new int[maxOrders[i]];
			int[] yArr = new int[maxOrders[i]];
			
			for(int j=0;j<maxOrders[i];j++) {
				xArr[j] = in.nextInt();
			}
			for(int j=0;j<maxOrders[i];j++) {
				yArr[j] = in.nextInt();
			}
			
			int max = findMaxTip(xArr,yArr,x[i],y[i]);
			System.out.println(max);
		}
	}

	private static int findMaxTip(int[] xArr, int[] yArr, int xmax, int ymax) {
		//Arrays.sort(xArr);
		//Arrays.sort(yArr);
		
		int length =  xArr.length;
		int[] mergeArr = new int[length];
		int i = 0;
		//int j = 0;
		int xcount = 0;
		int ycount = 0;
		int k = 0;
		
		while(k<length) {
			if(xArr[i] >= yArr[i]) {
				if(xcount<xmax) {
					mergeArr[k++] = xArr[i++];
					xcount++;
				}else if(ycount<ymax) {
					mergeArr[k++] = yArr[i++];
					ycount++;
				}
				
			}else {
				if(ycount<ymax) {
					mergeArr[k++] = yArr[i++];
					ycount++;
				}else if(xcount<xmax) {
					mergeArr[k++] = xArr[i++];
					xcount++;
				}
			}
		}
		
		int sum =0;
		for(int s : mergeArr) {
			sum = sum +s;
		}
		return sum;
	}

}
