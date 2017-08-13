package tgipl.test;

public class ThePlay {
	
	public static void main(String[] args) {
		//3,1,5)
		//,4,1,5)
		//,5,1,5)
		//,100,1,5)
		int t = 1;
		String arrange="(5,2,5)";
		int []a=Pairs(t, arrange);
		for (int b: a)
		{
			System.out.println(b);
		}
	}
	
	public static int[] Pairs(int t, String arrange)
	{
		String perform = arrange.replaceAll("(", "");
		//perform = perform.replaceAll(")", "");
		String[] arr= perform.split(")");
		int count=0;
		if(null!=arr && arr.length!=0)
		{
			
		}
		
		return null;
	}

}
