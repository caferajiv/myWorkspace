package tgipl.test;

public class HouseCondition {

	public static void main(String[] args) {
		int[] score={2,2,1,1,1};
		int houseIndex=3;
		
		System.out.println(house_condition(score, houseIndex));
		
	}

	public static int house_condition(int[] score, int houseIndex) {
		int[] condition = new int[score.length];
		for(int i=0; i<condition.length;i++)
		{
			condition[i]=1;
		}
		if(score[0]==1)
		{
			condition[1]=0;
		}
		else if(score[0]>1)
		{
			condition[1]=1;
		}
		
		for(int i=1;i<condition.length-1;i++)
		{
			int scor=0;
			if(i==condition.length-1)
			{
				scor=condition[i-1]+condition[i];
			}
			else
			{
				scor=condition[i-1]+condition[i]+condition[i+1];
			}
			
			if(scor>score[i])
			{
				condition[i+1]=0;
			}
			else if(scor==score[i])
			{
				continue;
			}
			else if(scor<score[i])
			{
				//return -1;
			}
		}
		
		return condition[houseIndex-1];
		
		
	}
}
