package tgipl.test;

public class PlanningStreet {
	
	public static void main(String[] args) {
		
		int input=4;
		System.out.println(getStreetPlan(input));
		
	}

	private static double getStreetPlan(int input) {
		if(input<=0 || input>1000) return 0;
		int count=0;
		int max =1<<input;
		for(int i=0;i<1<<input;i++)
		{
			String binary = Integer.toBinaryString(i);
			if(binary.indexOf("11")!=-1)count++;
			
		}
		int actualPerms=max-count;
		return actualPerms*actualPerms;
	}
	
	
}
