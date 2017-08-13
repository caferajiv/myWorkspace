package programmingchallenge;

/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
                                          // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{
    public void run(){
    	String input = Main.ReadLn(20);
    	System.out.println(input);
    	String[] inputArr = input.split(" ");
    	int min =  Integer.parseInt(inputArr[0].trim());
    	int max =  Integer.parseInt(inputArr[1].trim());
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
    
    // You can insert more classes here if you want.
}
