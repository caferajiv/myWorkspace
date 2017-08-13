package gipl;

/**
 * 
 * To print all the prime numbers less than the input number
 * @author RAJIV
 *
 */
public class PrintPrime {
	
	public static void main(String[] args)
	{
		printPrime(14);
	}
	
	private static void printPrime(int number)
	{
		boolean isPrime=true;
		for(int i=number;i>1;i--)
		{
			isPrime=true;
			for(int j=i-1;j>1;j--)
			{
				if(i%j==0)
				{
					isPrime=false;
					break;
				}
			}
			if(isPrime==true)
			{
				System.out.println(i+"is Prime");
				
			}
		}
		
	}

}
