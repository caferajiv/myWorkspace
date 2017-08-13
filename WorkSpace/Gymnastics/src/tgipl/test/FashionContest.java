package tgipl.test;

public class FashionContest {
	
	public static void main(String[] args) {
		
		int[] scores={-1};
		System.out.println(fashion(scores));
	}
	
	public static int fashion(int[] scores)
    {
		int total_score=0;
		if(scores.length>0)
		{
		int mid = scores.length/2;
		total_score=scores[mid];
		for(int i=0,j=scores.length-1;i<mid;i++,j-- )
		{
			if(scores[i]==scores[j])
			total_score=total_score+scores[i];
		}
		}
		return total_score;
    }

}
