package tgipl.test;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PassingTheParcel {
	
	public static void main(String[] args) {
		int numPlayers=11;
		int time=4;
		System.out.println(getWinner4(numPlayers, time));
	}
	
	public static int getWinner4(int numPlayers, int time) {

		if(numPlayers<=0) return -1;
		if(time<0) return -1;
		if(numPlayers==1)return 1;
		if(time==0) return numPlayers;
		List<Integer> list = new ArrayList<Integer>();
			for(int i=1; i<=numPlayers;i++)
			{
				list.add(i);
			}
			int countOfAlive=numPlayers;
			int count=0;
			while(true)
			{
				if(countOfAlive==1)
					break;
				Iterator<Integer> iterator = list.iterator();
				while(iterator.hasNext())
				{ int player = iterator.next();
						count++;
						if(count==time)
						{
							//iterator.next();
							iterator.remove();
							countOfAlive--;
							count=0;
						}
					
				}
			}
			for(int player : list)
	        return player;
	    
		
		return -1;
    
	}
	
	
	
	public static int getWinner3(int numPlayers, int time) {

		if(numPlayers<=0) return -1;
		if(time<=0) return -1;
		Set<Integer> set = new TreeSet<Integer>();
		for(int i=1; i<=numPlayers;i++)
		{
			set.add(i);
		}
		int countOfAlive=numPlayers;
		int count=0;
		while(true)
		{
			if(countOfAlive==1)
				break;
			Iterator<Integer> iterator = set.iterator();
			while(iterator.hasNext())
			{ int player = iterator.next();
					count++;
					if(count==time)
					{
						//iterator.next();
						iterator.remove();
						countOfAlive--;
						count=0;
					}
				
			}
		}
		for(int player : set)
        return player;
		
		return -1;
    
	}



	public static int getWinner2(int numPlayers, int time) {

		int[] players = new int[numPlayers]; 
		for(int i=0; i<numPlayers;i++)
		{
			players[i]=i+1;
		}
		int countOfAlive=numPlayers;
		int count=0;
		while(true)
		{
			if(countOfAlive==1)
				break;
			
			for(int i=0;i<numPlayers;i++)
			{
				if(players[i]!=-1)
				{
					count++;
					if(count==time)
					{
						players[i]=-1;
						countOfAlive--;
						count=0;
					}
				}
				
			}
		}
		
		for(int k : players)
		{
			if(k!=-1)
			{
				return k;
			}
		}
		return -1;
    
	}



	public static int getWinner(int numPlayers,int time)
    {
		List<Player> list = new ArrayList<Player>();
		for(int i=1; i<=numPlayers;i++)
		{
			list.add(new Player(i,false));
		}
		int countOfAlive=numPlayers;
		int count=0;
		while(true)
		{
			if(countOfAlive==1)
				break;
			
			for(Player player: list)
			{
				if(!player.isDead)
				{
					count++;
					if(count==time)
					{
						player.isDead=true;
						countOfAlive--;
						count=0;
					}
				}
			}
		}
		for(Player player : list)
		{
			if(!player.isDead)
			{
				return player.id;
			}
		}
        return 0;
    }
	
	static class Player
	{
		int id;
		boolean isDead;
				
		public Player(int id, boolean isDead)
		{
			this.id=id;
			this.isDead=isDead;
		}
	}
	

}
