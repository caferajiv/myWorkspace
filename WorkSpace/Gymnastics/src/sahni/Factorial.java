package sahni;

public class Factorial {
	
	/**
	 * F(0) =1;
	 * F(1) =1;
	 * F(n)= n*F(n-1);
	 * 
	 */
	public static void main(String args[]){
		//System.out.println(nonRecursiveFactorial(-1));
		System.out.println(recursiveFactorial(6));
		
	}
	
	public static int nonRecursiveFactorial(int n){
		if(n<0){
			System.out.println("Negative Number!!");
			return 0;
		}
		if(n==1 || n==0){
			return 1;
		}
		int p=1;
		while(n>1){
			p=p*n;
			n--;
		}
		return p;
	}
	
	public static int recursiveFactorial(int n){
		if(n<0){
			System.out.println("Negative Number!!");
			return 0;
		}
		if(n==1 || n==0){
			return 1;
		}
		int p=1;
		if(n>1){
			p=n*recursiveFactorial(--n);
			
		}
		return p;
	}

}
