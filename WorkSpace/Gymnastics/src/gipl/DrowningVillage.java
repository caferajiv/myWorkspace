package gipl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DrowningVillage {
	
	private static int[][] villageArray;
	
	public static void main(String[] args)
	{
		initializeVillageArray();
		
		List<Point> list= new ArrayList<Point>();
		list.add(new Point(1,3));
		
		printNextDrowningVillage(list);
		
	}
	
	private static void initializeVillageArray() {
		villageArray= new int[][]{{3,3,8},{2,9,2},{7,1,4}};
		
	}
	
	private static List<Point> getLowestPoints(List<Point> listOfPoints)
	{
		int lowestHeight=-1;
		List<Point> listOfLowestPoints=new ArrayList<Point>();
		for(Point point:listOfPoints)
		{
			
			if(lowestHeight==-1)
			{
				lowestHeight=getHeightOfPoint(point);
				listOfLowestPoints.add(point);	
			}else
			{
				if(lowestHeight>getHeightOfPoint(point))
				{
					lowestHeight=getHeightOfPoint(point);
					listOfLowestPoints.clear();
					listOfLowestPoints.add(point);
				}
				else if(lowestHeight==getHeightOfPoint(point)) 
				{
					listOfLowestPoints.add(point);
				}
			}
		}
		return listOfLowestPoints;
	}

	private static int getHeightOfPoint(Point point) {
		
		
		return villageArray[point.getX()][point.getY()];
		
	}

	private static void printNextDrowningVillage(List<Point> listOfPoints)
	{
		List<Point> neighbouringPoints=new ArrayList<Point>();
		for(Point point : listOfPoints)
		{
			System.out.println("Next drowning:"+point + " At Height:"+getHeightOfPoint(point));
			neighbouringPoints.addAll(getNeighbouringPoints(point));
		}
		
		printNextDrowningVillage(neighbouringPoints);
		
	}

	private static List<Point> getNeighbouringPoints(Point point) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(point.getX()-1,point.getY()));
		list.add(new Point(point.getX()+1,point.getY()));
		list.add(new Point(point.getX(),point.getY()+1));
		list.add(new Point(point.getX(),point.getY()-1));
		return list;
	}

}
class Point 
{
	private int x;
	private int y;
	
	Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public String toString()
	{
		return x + " , " + y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
