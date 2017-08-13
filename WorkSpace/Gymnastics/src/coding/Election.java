package coding;


import sort.QuickSort;

public class Election {
	
	public static void main(String[] args) {
		int[] a = new int[] { 3, 3, 7, 14, 4, 4, 4, 67, 34, 24,
				17, 5, 5 }; 
		int low=0;
		int high= a.length-1;
		QuickSort.quicksort(a,low, high);
		int currentCandidate=a[0];
		int maxCandidate=currentCandidate;
		int currentCount=0;
		int maxCount=0;
		for (int i=0 ; i<a.length; i++) {
			if(currentCandidate==a[i])
			{
				currentCount++;
			}
			else if(currentCandidate!=a[i])
			{
				currentCandidate=a[i];
				currentCount=1;
			}
			
			if(maxCount<currentCount)
			{
				maxCount=currentCount;
				maxCandidate=currentCandidate;
			}
		}
		System.out.println("Candidate "+ maxCandidate +" wins by "+maxCount +" votes..");
	}

}
