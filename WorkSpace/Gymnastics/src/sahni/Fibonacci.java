package sahni;

public class Fibonacci {
	/**
	 * F(0)=0;
	 * F(1)= 1;
	 * F(n)= F(n-1)+ F(n-2);
	 * 
	 */
	
	public static void main(String args[]){
		//nonRecursiveFibonacci(15);
		//recursiveFibonacci(3);
		printFibonacci(5);
	}
	
	private static void printFibonacci(int n) {
		
		for(int i=0;i<n;i++)
		{
			System.out.print(fibonacci(i));
		}
		
	}

	public static int recursiveFibonacci(int n){
		int N1=1;
		int N2=0;
		int temp=0;
		if(n>1){
			if(n==1){
			System.out.print(N2+N1+" ");
			return(1);
			}
			if(n==0){
				return 1;
			}
			//N1=recursiveFibonacci(n-1);
			//N2=recursiveFibonacci(n-2);
			//System.out.print(recursiveFibonacci(n-1)+recursiveFibonacci(n-2)+" ");
			
		}
		for(int i=2;i<=n;i++){
			System.out.print(N2+N1+" ");
			temp=N1;
			N1=N1+N2;
			N2=temp;
		}
		return 0;
	}

	public static int nonRecursiveFibonacci(int n){
		int N1=1;
		int N2=0;
		int temp=0;
		if(n>1){
			System.out.print(N2+N1+" ");
		}
		for(int i=2;i<=n;i++){
			System.out.print(N2+N1+" ");
			temp=N1;
			N1=N1+N2;
			N2=temp;
		}
		return 0;
	}
	
	public static int fibonacci(int n)
	{
		if(n<=1)
		{
			return 1;
		}
		else
		{
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
