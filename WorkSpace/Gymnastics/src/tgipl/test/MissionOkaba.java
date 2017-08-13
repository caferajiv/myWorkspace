package tgipl.test;

public class MissionOkaba {
	
	
	public static void main(String[] args) {
		int marineCount=2;
		int []marinePositions = {5,5, 5,3};
		System.out.println(GetBuildingCount(marineCount,marinePositions));
	}
	
	public static int GetBuildingCount(int input1,int[] input2)
    {
		  int[][] guarded = new int[8][8];
		  for(int i=0;i<8;i++)
		  {
			  for (int j=0;j<8;j++)
			  {
				  guarded[i][j]=0;
			  }
		  }
		int [][]marinePos=make2DArray(input1,input2);
		
		for(int i=0;i<input1;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(j==0)
				{
				int row=marinePos[i][0]-1;
				for(int k=0;k<8;k++)
					guarded[row][k]=1;
				}
				if(j==1)
				{
				int col=marinePos[i][1]-1;
				for(int k=0;k<8;k++)
					guarded[k][col]=1;
				}
			}
		}
		int sum=0;
		for(int i=0;i<8;i++)
		{
			for( int j=0;j<8;j++)
			{
				if(guarded[i][j]==1) sum++;
			}
		}
        return sum;
    }

	private static int[][] make2DArray(int marineCount,int[] input) {
		int[][]a= new int[marineCount][2];
		int j=0;
		for(int i=0;i<marineCount;i++)
		{
			a[i][0]=input[j++];
			a[i][1]=input[j++];
		}
		return a;
	}

}
