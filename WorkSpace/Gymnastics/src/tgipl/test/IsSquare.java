package tgipl.test;

public class IsSquare {
	
	public static void main(String[] args) {
		int number=6;
		 System.out.println(isSquare(number));
	}

	private static boolean isSquare(int number) {
		
		if(number<=1)
			return false;
		//number which is square will have odd number of factors
		// another way just multiply each integer starting from 2 and check when
		//it crosses the number.
		int factors = getNumberOfFactors(number);
		
		if(factors%2!=0)
			return true;
		
		return false;
	}

	private static int getNumberOfFactors(int number) {
		int countFactors=0;
		for(int i=1;i<=number; i++)
		{
			if(number%i==0)
			countFactors++;
		}
		return countFactors;
	}

}
