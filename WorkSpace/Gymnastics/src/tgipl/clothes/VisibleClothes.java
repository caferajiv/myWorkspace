package tgipl.clothes;

import java.util.List;

public class VisibleClothes {
	
	private static int visibleClothes;
	private static int ropeLength;
	private static int [][]clothPos;
	private static int clothCount;
	private static List listOfClothes;
	
	private static void initialize()
	{
		ropeLength=10;
		clothPos=new int [][]{{0,4},{6,3},{1,5},{6,4},{7,2}};
		clothCount=5;
	}
	
	public static void main(String args[])
	{
		initialize();
	}
	
	private static void checkClothVisibility()
	{
		for (int i=0; i<clothPos.length;i++)
		{
			Cloth cloth= new Cloth();
			//listOfClothes.add()
		}
	}

}
