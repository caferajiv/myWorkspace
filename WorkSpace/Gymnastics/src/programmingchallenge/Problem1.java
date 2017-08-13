package programmingchallenge;

/**
 * The 3n + 1 Problem
 * PC ID: 110101
 * 
 *
 */
public class Problem1 {
	public static void main(String[] args) {
		// Sample input 
		int min=1;
		int max=10;
		System.out.println(min+" "+max+" "+findMaxCycleLength(min,max));
	}

	/**
	 * Accepts input numbers and find the maximum cycle length for that range.
	 * @param min
	 * @param max
	 * @return
	 */
	private static int findMaxCycleLength(int min, int max) {
		// cycle length for each number in the range
		int currentCycleLength=0;
		// variable to track the max cycle length so far in the range
		int maxCycleLength=0;
		//loop through the range 
		for(int i=min;i<max+1;i++)
		{   int cycleCounter=0;
		    int currentNumber=i;
			while(currentNumber!=1)
			{   cycleCounter=1;
			//if the number is even
				if(currentNumber%2==0)
				{
					currentNumber=currentNumber/2;
					
				}//if the number is odd
				else
				{
					currentNumber=currentNumber*3+1;
					
				}
				cycleCounter++;
			}
			currentCycleLength=cycleCounter;
			//if the current cycle length is greater than the max cycle length then
			// update the max cycle length
			if(currentCycleLength>maxCycleLength)
			{
				maxCycleLength=currentCycleLength;
			}
		}
		return maxCycleLength;
	}

}
