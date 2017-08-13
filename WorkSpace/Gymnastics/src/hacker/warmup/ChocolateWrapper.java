package hacker.warmup;

import java.util.Scanner;

public class ChocolateWrapper {
	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
	
private static long Solve(int n, int c, int w){
        
    	long chocolate_ate = n/c;
		long wrapper_left = n/c;
		while(wrapper_left>=w){
			
			chocolate_ate = chocolate_ate+wrapper_left/w;
			wrapper_left=(wrapper_left%w)+(wrapper_left/w);
		}
		
		return chocolate_ate;
    }
    
    
	

}
