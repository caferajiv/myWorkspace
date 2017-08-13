package tgipl.test;

public class EscapeTihar {
	
	public static void main(String[] args) 
	{
		//5,0,10,{20,35,82,77,23,11,9,12,33,13}
		int climbUp=5; 
		int climbDown=0; 
		int noOfWalls=10;
		int[] wallHeights={20,35,82,77,23,11,9,12,33,13};
		System.out.println(GetJumpCount(climbUp,climbDown,noOfWalls,wallHeights));
		
	}
	
	public static int GetJumpCount(int climbUp, int climbDown, int noOfWalls,
			int[] wallHeights) 
	{
		int totalJumps=0;
		for (int wall: wallHeights)
		{
			totalJumps=totalJumps+jumpsRequired(climbUp, climbDown, wall);
		}
		return totalJumps;
	}
	private static int jumpsRequired(int climbUp, int climbDown, int wallHeight)
	{
		if(wallHeight<=climbUp)return 1;
		else
		{
			int newWallHeight=wallHeight-(climbUp-climbDown);
			return 1+jumpsRequired(climbUp, climbDown, newWallHeight);
		}
		
	}

	
}
