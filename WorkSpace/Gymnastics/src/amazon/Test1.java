package amazon;

public class Test1 {

	public static void main(String args[])
	{
		swapSort("00101011");
	}
	
	public static int swapSort(String s) {
		int swaps=0;
	    char[] charArray = s.toCharArray();
	    System.out.println(charArray);
	    int[] arr = new int[s.length()];
	    int length = arr.length;
	    for(int i=0;i<length;i++)
	    {
	        arr[i]=charArray[i];
	    }
	    //0 0 1 0 1 0 1 1
	    //0 0 0 1 1 0 1 1
 	    for(int j=0;j<length;j++)
	    { 
	    	if(j<(length/2) && j+1<(length/2) )
	    	{
	    	if(arr[j]==arr[j+1])
	    	{
	    		continue;
	    	}
	    	else
	    	{
	    		if(arr[j] < arr[j+1])
	    		{
	    			continue;
	    		}else
	    		{
	    			swap(arr,j);
	    			swaps++;
	    		}
	    	}//0 0 0 1 0 1 1 1
	    	}else if(j<(length/2) && j+1>=(length/2))
	    	{
	    		if(arr[j]==arr[j+1])
		    	{
		    		continue;
		    	}
		    	else
		    	{
		    		if(arr[j] < arr[j+1])
		    		{
		    			continue;
		    		}else
		    		{
		    			swap(arr,j);
		    			swaps++;
		    		}
		    	}
	    	}
	    	else if(j>=(length/2) && j+1>(length/2))
	    	{
	    		if(arr[j]==arr[j+1])
		    	{
		    		continue;
		    	}
		    	else
		    	{
		    		if(arr[j] < arr[j+1])
		    		{
		    			continue;
		    		}else
		    		{
		    			swap(arr,j);
		    			swaps++;
		    		}
		    	}
	    	}
	    	
	    }
 	 //0 0 0 1 0 1 1 1
    	if(arr[length/2]>arr[length/2+1])
    	{
    		swap(arr,length/2);
    		swaps++;
    	}
	    return swaps;
	}
	
	public static int[] swap(int arr[],int j)
	{
		int temp=arr[j];
		arr[j]=arr[j+1];
		arr[j+1]=temp;
		
		return arr;
	}
	
}
