package hacker.algo.impl;

import java.util.Scanner;

public class BonAppetit {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 int items = in.nextInt();
		 int index = in.nextInt();
		 int[] prices = new int[items];
		 int totalCost = 0;
		 for(int i=0;i<items;i++){
			 int price = in.nextInt();
			 prices[i]= price;
			 totalCost =totalCost+price;
		 }
		 int charged = in.nextInt();
		 
		 if(charged == (totalCost-prices[index])/2){
			 System.out.println("Bon Appetit");
		 }else{
			 System.out.println(charged - ((totalCost-prices[index])/2));
		 }
		 }
		 
	}


