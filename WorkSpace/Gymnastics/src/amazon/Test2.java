package amazon;

public class Test2 {
	
	public static void main(String args[])
	{
		
	}
	
	public static int countPaths(int x1, int y1, int x2, int y2) {
         int paths=2;
         if(x2-x1==0)
         {
        	 paths= paths-1;
         }
         if(y2-y1==0)
         {
        	 paths = paths -1;
         }
		
		return paths;
	}

}
