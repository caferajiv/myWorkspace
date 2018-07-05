package coderust.dp;

public class GameScoring {
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println(scoring_options(n));
	}
	public static int scoring_options(int n) {
	    
		int[] arr = new int[n+1];
		
		int[] options = {1,2,4};
		for(int option: options) {
			if(option<=n) {
				arr[option] = 1;
			}
		}
		//if(arr[n]!=0) return arr[n];
		
		for(int i=1;i<=n;i++) {
						
			for(int option : options) {
				if(option<=i) {
					arr[i] = arr[i] + arr[i-option];
				}
		    }
		}
		
	     return arr[n];
	  }

}
