package programmingchallenge;

public class Minesweeper {
	
	public static void main(String[] args) {
	
		
		String[][] inputArr = new String[][]{{"*","*","0","0","0"},
				{"0","0","0","0","0"},
				{"0","*","0","0","0"}};
				
		
		for(String [] c: inputArr)
		{
			for(String c1: c)
			{
				System.out.print(c1);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		String [][]outputArr = findTheMines(inputArr);
		
		
		
		for(String [] c: outputArr)
		{
			for(String c1: c)
			{
				System.out.print(c1);
			}
			System.out.println();
		}
	}

	private static String[][] findTheMines(String[][] inputArr) {
		int outerLength=inputArr.length-1;
		for(int i=0;i<inputArr.length;i++)
		{ int innerLenth=inputArr[i].length-1;
			for(int j=0;j<inputArr[i].length;j++)
			{
				if(inputArr[i][j].equals("*"))
				{
					//check the left-top quad
					
					if(i-1>=0)
					{
						if(!inputArr[i-1][j].equals("*"))
						{
						int val = Integer.parseInt(inputArr[i-1][j]);
						val++;
						inputArr[i-1][j] = String.valueOf(val);
						}
					}
					if(j-1>=0)
					{
						if(!inputArr[i][j-1].equals("*"))
						{
						int val = Integer.parseInt(inputArr[i][j-1]);
						val++;
						inputArr[i][j-1] = String.valueOf(val);
						}
					}
					if(i-1>=0 && j-1>=0)
					{
						if(!inputArr[i-1][j-1].equals("*")){
						int val = Integer.parseInt(inputArr[i-1][j-1]);
						val++;
						inputArr[i-1][j-1] = String.valueOf(val);
						}
							
					}
					
					//check the bottom-right quad
					
					if(i+1<=outerLength)
					{
						if(!inputArr[i+1][j].equals("*")){
						int val = Integer.parseInt(inputArr[i+1][j]);
						val++;
						inputArr[i+1][j] = String.valueOf(val);
						}
					}
					if(j+1<=innerLenth)
					{
						if(!inputArr[i][j+1].equals("*")){
						int val = Integer.parseInt(inputArr[i][j+1]);
						val++;
						inputArr[i][j+1] = String.valueOf(val);
						}
					}
					if(i+1<=outerLength && j+1<=innerLenth)
					{
						if(!inputArr[i+1][j+1].equals("*")){
						int val = Integer.parseInt(inputArr[i+1][j+1]);
						val++;
						inputArr[i+1][j+1] = String.valueOf(val);
						}
							
					}
					
					//check the bottom-left quad
					
					if(i+1<=outerLength && j-1>=0)
					{
						if(!inputArr[i+1][j-1].equals("*")){
						int val = Integer.parseInt(inputArr[i+1][j-1]);
						val++;
						inputArr[i+1][j-1] = String.valueOf(val);
						}
							
					}
					
					//check the bottom-right quad
					if(i-1>=0 && j+1<=innerLenth)
					{
						if(!inputArr[i-1][j+1].equals("*")){
						int val = Integer.parseInt(inputArr[i-1][j+1]);
						val++;
						inputArr[i-1][j+1] = String.valueOf(val);
						}
					}
				}
			}
		}
		
		return inputArr;
	}

}
