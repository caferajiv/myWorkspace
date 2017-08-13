package tgipl.test;

public class BestBowler {
	
	public static void main(String[] args) {
		
		int noOfBowlers=5;
		String performance="{2210011,1115422363,4645637468,023013,1323402022}";
		System.out.println(BestBowler(noOfBowlers, performance));
	}
	
	public static int  BestBowler(int noOfBowlers, String performance)
	{
		String perform = performance.replaceAll("{", "");
		perform = perform.replaceAll("}", "");
		String[] arr= perform.split(",");
		int count=0;
		for(String s : arr)
		{
			if(s!=null && s.length()!=0)
			{
				long num = Long.parseLong(s);
				long total=0;
				while(num!=0)
				{
					total = total+(num % 10);
					num=num/10;
				}
				if(total/s.length()>=5) count++;
			}
		}
		return count;
	}

}
