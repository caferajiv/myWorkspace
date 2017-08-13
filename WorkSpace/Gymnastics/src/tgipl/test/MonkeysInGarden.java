package tgipl.test;

import java.util.ArrayList;
import java.util.List;


public class MonkeysInGarden {
	
	public static void main(String[] args) {
		int[] treeheights = {1,1,1,1,1,1,1,1};
		System.out.println(monkey(treeheights));
	}
	
	public static int monkey(int[] treeHeights)
    {
		if(treeHeights.length<1)
			return 0;
		if(treeHeights.length==1)
			return treeHeights[0];
		if(treeHeights.length==2)
			return treeHeights[0]+treeHeights[1]+1;
		int maxHeight=treeHeights[0];
		for(int height: treeHeights)
		{
			if(height>maxHeight)
			{
				maxHeight=height;
			}
		}
		int indexOfMaxheight=getIndexOfHeight(maxHeight,treeHeights);
		//set max height tree to index 0 for simplicity in calculation
		treeHeights = rearrangeTreeheightsArray(indexOfMaxheight,treeHeights);
		//start a loop move one index in anticlock from max and one 
		//index towards clockwise and find max.
		int maxDistanceClock=0;
		int clockwisedistance=0;
		int anticlockwisedistance=0;
		int maxDistanceAnticlock=0;
		/*for(int i=indexOfMaxheight+1,j=indexOfMaxheight-1;i!=j;)
		{
			if(i>=treeHeights.length && i!=j)
			{
				i=0;
			}
			if(j<0 && j!=i)
			{
				j=treeHeights.length-1;
			}
			int imaxDistance=maxHeight+treeHeights[i]+(++clockwisedistance);
			if(imaxDistance>maxDistanceClock)
			{
				maxDistanceClock=imaxDistance;
			}
			
			int jmaxDistance=maxHeight+treeHeights[j]+(++anticlockwisedistance);
			if(jmaxDistance>maxDistanceAnticlock)
			{
				maxDistanceAnticlock=jmaxDistance;
			}
			
			i++;
			if(i==j) break;
			j--;
			
			
		}*/
		
		for(int i=1,j=treeHeights.length-1;;)
		{
			/*if(i>=treeHeights.length && i!=j)
			{
				i=0;
			}
			if(j<0 && j!=i)
			{
				j=treeHeights.length-1;
			}*/
			int imaxDistance=maxHeight+treeHeights[i]+(++clockwisedistance);
			if(imaxDistance>maxDistanceClock)
			{
				maxDistanceClock=imaxDistance;
			}
			
			int jmaxDistance=maxHeight+treeHeights[j]+(++anticlockwisedistance);
			if(jmaxDistance>maxDistanceAnticlock)
			{
				maxDistanceAnticlock=jmaxDistance;
			}
			
			i++;
			j--;
			if(i>j) break;
			//if(i==j) break;
			
			
			
		}
		
		if(maxDistanceClock>maxDistanceAnticlock)
		{
			return maxDistanceClock;
		}
		
        return maxDistanceAnticlock;
    }

	private static int [] rearrangeTreeheightsArray(int indexOfMaxheight,
			int[] treeHeights) 
	{
		if(indexOfMaxheight==0)
			return treeHeights;
		List<Integer> list = new ArrayList<Integer>();
		for(int height : treeHeights)
		{
			list.add(height);
		}
		for(int i=list.size()-1;i>=indexOfMaxheight;i--)
		{
			Integer val=list.remove(i);
			list.add(0, val);
		}
		treeHeights = new int[list.size()];
		int j=0;
		for(int v : list)
		{
			treeHeights[j]=v;
			j++;
		}
		return treeHeights;
	}

	private static int getIndexOfHeight(int maxHeight, int[] treeHeights) {
		for(int i=0;i<treeHeights.length;i++)
		{
			if(maxHeight==treeHeights[i])
			{
				return i;
			}
		}
		return -1;
	}

}
