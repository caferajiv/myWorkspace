package hacker.arraysSort;

import java.util.Scanner;

public class SherlockArray {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
   		
		int noOfTestcases = in.nextInt();
		
		int[][] arrays = new int[noOfTestcases][];
		
		for(int i=0;i<noOfTestcases;i++){
			System.out.println("test"+noOfTestcases);
			int arrayLength = in.nextInt();
			System.out.println(arrayLength);
			int j=0;
			for(;j<arrayLength;j++){
				System.out.print(in.nextInt());
				//arrays[i][j]=in.nextInt();
			}
		}
		
		
		for(int i=0;i<arrays.length;i++){
			boolean flag=false;
			//for(int j=0;j<arrays[i].length;j++){
				
				int length = arrays[i].length;
				int midIndex = length/2;
				int leftSum=0;
				int rightSum=0;
				for(int l=0;l<midIndex;l++){
					leftSum=leftSum+arrays[i][l];
				}
				
				for(int r=midIndex+1;r<length;r++){
					rightSum=rightSum+arrays[i][r];
				}
				
				while(midIndex<0 || midIndex>arrays[i].length-1){
					if(leftSum==rightSum){
						flag=true;
						break;
					}else{
						if(leftSum>rightSum){
							midIndex=midIndex-1;
							leftSum=leftSum-arrays[i][midIndex-1];
							rightSum=rightSum+arrays[i][midIndex];
						}else{
							midIndex=midIndex+1;
							leftSum=leftSum+arrays[i][midIndex];
							rightSum=rightSum-arrays[i][midIndex];
						}
						
						
					}
				}
				
				if(flag==true){
					System.out.println("YES");
				}else
				{
					System.out.println("NO");
				}
				
				
				
			//}
		}
	}

}
