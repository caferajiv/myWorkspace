package tgipl.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DrowningVillage {
	
	
	private static int [][] villageArr;
	private static int size;
	public static int[] output1; 
	public static void main(String[] args) {
		
		int arrsize = 9;
		int []inputArray = {3,1,9,2,8,0,5,9,3,5,7,1,4,8,9,6,6,9,0,4,5,5,8,8,0,0,5,0,6,0,4,6,1,8,3,9,1,1,6,4,7,7,9,2,1,7,3,6,3,5,9,6,5,9,0,1,6,0,1,3,4,3,0,3,9,4,2,7,2,8,9,0,8,0,7,0,3,8,4,0,1};
		int [] origin= {4,8};
		
		int []drown=DrowningVillage(arrsize,inputArray,origin);
		for(int d: drown)
		{
			System.out.print(d);
		}
		
	}
	public static int[] DrowningVillage(int arrSize,int[] inputArray,int[] origin)
    {
		output1 = new int[arrSize*arrSize];
		size=arrSize;
		villageArr = make2DArray(inputArray,arrSize);
		List<Point> drowningList = new ArrayList<Point>();
		List<Point> drownedSet = new ArrayList<Point>();
		
		int i= origin[1]-1;
		int j= origin[0]-1;
		int height = villageArr[i][j]; 
		Point startPoint = new Point(origin[1]-1, origin[0]-1,height);
		startPoint.isDrowned=true;
		drowningList.add(startPoint);
		while(drowningList.size()!=0)
		{
			Point p = drowningList.remove(0);
			if(!drownedSet.contains(p))
			{
				drownedSet.add(p);
			}
			if(drownedSet.size()==arrSize*arrSize) break;
			
			
			while( drowningList.size()!=0 &&p.height==drowningList.get(0).height)
			{
				Point q = drowningList.remove(0);
				if(!drownedSet.contains(p))
				{
					drownedSet.add(q);
				}
				
				//if(drownedSet.size()==villageArr.length) break;
				for(Point newPoint : q.getNeighbours())
				{
					if(!drownedSet.contains(newPoint) && !drowningList.contains(newPoint) )
					{
						drowningList.add(newPoint);
					}
				}
				
			}
			for(Point newPoint : p.getNeighbours())
			{
				if(!drownedSet.contains(newPoint) && !drowningList.contains(newPoint))
				{
					drowningList.add(newPoint);
				}
			}
			//drowningList.addAll(p.getNeighbours());
			Collections.sort(drowningList);
			
		}
		
		Point [] a = new Point[0];
		a=drownedSet.toArray(a);
		//output1 = new int[a.length];
		int l=0;
		for(Point m : a)
		{
			output1[l]=m.height;
			l++;
		}
        return output1;
    }
	
	private static int[][] make2DArray(int[] inputArray, int size) {
		int[][]a= new int[size][size];
		int k=0;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{				
				a[i][j]=inputArray[k++];
			}
		}
		return a;
	}
	
	static class Point implements Comparable<Point>
	{
		int i;
		int j;
		int height;
		boolean isDrowned=false;
		public Point()
		{
			
		}
		
		public Point(int i, int j, int height)
		{
			this.i=i;
			this.j=j;
			this.height=height;
			
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Point)
			{
				return height==((Point)obj).height && i==((Point)obj).i && j==((Point)obj).j;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			
			int hash = 1;
	        hash = hash * 17 + i;
	        hash = hash * 31 + j;
	        hash = hash * 13 + height;
	        return hash;
		}
		
		@Override
		public String toString() {
			
			return height+"";
		}

		@Override
		public int compareTo(Point o) {
			
			return Integer.valueOf(height).compareTo(o.height);
		}
		
		public List<Point> getNeighbours()
		{
			List<Point> neighbourList = new ArrayList<Point>();
			if(i!=0)
			{
				Point neighbour= new Point(i-1,j,villageArr[i-1][j]);
				neighbourList.add(neighbour);
			}
			if(j!=0)
			{
				Point neighbour= new Point(i,j-1,villageArr[i][j-1]);
				neighbourList.add(neighbour);
			}
			
			if(i!=size-1)
			{
				Point neighbour= new Point(i+1,j,villageArr[i+1][j]);
				neighbourList.add(neighbour);
			}
			if(j!=size-1)
			{
				Point neighbour= new Point(i,j+1,villageArr[i][j+1]);
				neighbourList.add(neighbour);
			}
			return neighbourList;
		}
	}

}
