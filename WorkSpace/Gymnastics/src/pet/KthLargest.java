package pet;

public class KthLargest {
	
	public static void main(String[] args) {
		int[] input = {4,7,6,3,9,23,17,13,19,1};
		
		int K = 3;
		int low = 0;
		int high = input.length-1;
		int indexToFind = input.length-K+1;
		
		System.out.println(findKthLargest(input, indexToFind, low, high));
		
	}

	private static int findKthLargest(int[] input, int indexToFind ,int min ,int max) {
		if(min==max) return input[min];
		if(min<max){		
		int partitionIndex = partition(input,min, max);
			
		if(partitionIndex == indexToFind){
			return input[partitionIndex];
		}else if(partitionIndex>indexToFind){
			return findKthLargest(input, indexToFind,min, partitionIndex);
		}else{
			return findKthLargest(input, indexToFind,partitionIndex+1,max);
		}
		
	}
		return -1;
	}

	private static int partition(int[] input, int low, int high) {
		int pivot = (low+high)/2;
		
		int pivotElement = input[pivot];
		int start = low;
		int end = high;
		while(start<end){
			while(start<end && input[start]<=pivot){
				start++; 
			}
			
			while(start<end && input[end]>pivot){
				end--; 
			}
			
			if(start<end){
				swap(input,start,end);
			}
		}
		//pivot = end;
		input[pivot] = input[end];
		input[end] = pivotElement;
		return end;
	}

	private static void swap(int[] input, int start, int end) {
		int temp = input[start];
		input[start] = input[end];
		input[end]=temp;
		
	}

}
