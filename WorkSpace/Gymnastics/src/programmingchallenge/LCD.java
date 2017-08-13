package programmingchallenge;

import java.util.ArrayList;
import java.util.List;

public class LCD {
	
	/**   0
	 *   --
	 * 1|  |2
	 *  |  |
	 * 3 --
	 * 4|  |5
	 *  |  |
	 *   --
	 *    6
	 * 
	 */
	private static final String CODE_For_0 = "1110111";
	private static final String CODE_For_1 = "0010010";
	private static final String CODE_For_2 = "1011101";
	private static final String CODE_For_3 = "1011011";
	private static final String CODE_For_4 = "0111010";
	private static final String CODE_For_5 = "1101011";
	private static final String CODE_For_6 = "1101111";
	private static final String CODE_For_7 = "1010010";
	private static final String CODE_For_8 = "1111111";
	private static final String CODE_For_9 = "1111010";
			
	
	public static void main(String[] args) {
		
		int number = 123405;
		int rep=1;
		//drawEight();
		printLCD(rep, number);
		
	}


	private static void printLCD(int rep,int number) {
		List<Integer> list= new ArrayList<Integer>();
		while(number!=0)
		{
			list.add(number%10);
			number=number/10;
		}
		
		for(int i=list.size()-1;i>=0;i--)
		{
			String digitCode=getDigitCode(list.get(i));
			System.out.print(" ");
			printCode(digitCode);
		}
		
	}


	private static void printCode(String digitCode) {
		char [] arr = digitCode.toCharArray();
		//drawEight();
		if(arr[0]=='0'){}
		if(arr[0]=='1'){printZeroBit(1);}
		if(arr[1]=='1' && arr[2]=='1'){printOneAndTwo(1);}
		else if(arr[1]=='1' && arr[2]=='0'){printOneSkipTwo(1);}
		else if(arr[1]=='0' && arr[2]=='1'){printTwoSkipOne(1);}
		
		if(arr[3]=='0'){}
		if(arr[3]=='1'){printZeroBit(1);}
		if(arr[4]=='1' && arr[5]=='1'){printOneAndTwo(1);}
		else if(arr[4]=='1' && arr[5]=='0'){printOneSkipTwo(1);}
		else if(arr[4]=='0' && arr[5]=='1'){printTwoSkipOne(1);}
		
		if(arr[6]=='0'){}
		if(arr[6]=='1'){printZeroBit(1);}
		
	}


	private static void drawEight() {
		System.out.print(" ");
		System.out.print(" ");
		//print 0 bit
		printZeroBit(3);
		
		//print 1  and 2 bit
		printOneAndTwo(3);
		
		printZeroBit(3);
		
		printOneAndTwo(3);
		
		printZeroBit(3);
		
	}


	private static void printOneAndTwo(int rep) {
		
		for(int i=0;i<rep;i++ )
		{
			System.out.println();
			System.out.print("|");
			for(int j=0;j<rep;j++ )
			{
				System.out.print(" ");
			}
			//System.out.print(" ");
			System.out.print("|");
		}
		
		
		//System.out.println();
		//System.out.print("|");
		//System.out.print(" ");
		//System.out.print(" ");
		//System.out.print("|");
	}

	private static void printOneSkipTwo(int rep) {
		for(int i=0;i<rep;i++)
		{
			System.out.println();
			System.out.print("|");
			for(int j=0;j<rep;j++)
			System.out.print(" ");
			
		}
		
		//System.out.print("|");
		
		//System.out.println();
		//System.out.print("|");
		//System.out.print(" ");
		//System.out.print(" ");
		//System.out.print("|");
	}
	
	private static void printTwoSkipOne(int rep) {
		for(int i=0;i<rep;i++)
		{
			System.out.println();
			//System.out.print("|");
			for(int j=0;j<rep;j++)
			{
				System.out.print(" ");
			}
			
			System.out.print("|");
		}
		
		
		
		//System.out.println();
		//System.out.print("|");
		//System.out.print(" ");
		//System.out.print(" ");
		//System.out.print("|");
	}

	private static void printZeroBit(int rep) {
		//System.out.println();
		System.out.print(" ");
		for(int i=0;i<rep;i++)
		{
			System.out.print("-");
		}
		//System.out.print("-");
	}


	private static String getDigitCode(Integer integer) {
		int digit = integer;
		String digitCode="";
		switch (digit)
		{
		case 1: 
			digitCode=CODE_For_1;
			break;
		case 2: 
			digitCode=CODE_For_2;
			break;
		case 3: 
			digitCode=CODE_For_3;
			break;
		case 4: 
			digitCode=CODE_For_4;
			break;
		case 5: 
			digitCode=CODE_For_5;
			break;
		case 6: 
			digitCode=CODE_For_6;
			break;
		case 7: 
			digitCode=CODE_For_7;
			break;
		case 8: 
			digitCode=CODE_For_8;
			break;
		case 9: 
			digitCode=CODE_For_9;
			break;
		case 0: 
			digitCode=CODE_For_0;
			break;
		}
		return digitCode;
	}

}
