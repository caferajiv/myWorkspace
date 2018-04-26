package com.data.heap;


public class Heap {

	int[] heapArray;
	int heap_type;
	int count;
	int capacity;
	public static final int MIN_HEAP=0;
	public static final int MAX_HEAP=1;
	public Heap(int capacity, int heap_type){
		this.heap_type=heap_type;
		this.capacity=capacity;
		heapArray=new int[capacity];
	}
	
	public int getLeftChild(int i){
		int left=2*i+1;
		if(left>=count) return -1;
		
		return left;
	}
	
	public int getRightChild(int i){
		int right=2*i+2;
		if(right>=count) return -1;
		
		return right;
	}
	
	public int getParent(int i){
		if(i<=0||i>=count) return -1;
		
		return (i-1)/2;
	}
	
	public void heap_Up(int i){
		
	}
	
	private static void swap(int []arr, int i , int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
	}
	
	/**
	 * percolate_Down method designed assuming its a max heap
	 * @param i
	 */
	
	public void percolate_Down(int i){
		
		int leftChildIndex, rightChildIndex, maxIndex;
		maxIndex=i;
		leftChildIndex = getLeftChild(i);
		rightChildIndex = getRightChild(i);
		if(leftChildIndex==-1 && rightChildIndex==-1) return;
		if(leftChildIndex!=-1){
			if(heapArray[leftChildIndex]>heapArray[maxIndex]){
				maxIndex=leftChildIndex;
			}
		}
		if(rightChildIndex!=-1){
			if(heapArray[rightChildIndex]>heapArray[maxIndex]){
				maxIndex=rightChildIndex;
			}
		}
		
		if(maxIndex!=i){
			swap(heapArray,maxIndex,i);
			percolate_Down(maxIndex);
		}
		
	}
	
	/**
	 * reHeap_Up scenario is encountered when we add new elements to 
	 * the heap, then the heap has to be build up from bottom to top.
	 */
	public void reHeap_Up(int i){
		int parentIndex = getParent(i);
		if(parentIndex!=-1){
			if(heapArray[parentIndex]<heapArray[i]){
			swap(heapArray,parentIndex,i);
		}
		}
		reHeap_Up(parentIndex);
	}

	
	public void heap_Down(int i){
		int leftChild,rightChild,maxIndex;
		maxIndex=i;
		leftChild=getLeftChild(i);
		rightChild=getRightChild(i);
		if(leftChild==-1 && rightChild==-1) return ;
		if(leftChild!=-1 && heapArray[leftChild]>heapArray[maxIndex])
			maxIndex=leftChild;
		if(rightChild!=-1 && heapArray[rightChild]>heapArray[maxIndex])
			maxIndex=rightChild;
		
		if(maxIndex!=i){
			swap(this.heapArray,maxIndex,i);
			heap_Down(maxIndex);
		}
		
	}
	
	public int deleteMax()
	{
		if(count<=0) return -1;
		int max=heapArray[0];
		heapArray[0]=heapArray[count-1];
		count--;
		heap_Down(0);
		return max;
	}
	
	public void add(int data)
	{
		if(count==capacity)
			resizeHeap();
		heapArray[count]=data;
		count++;
		int i=count-1;
		int parentIndex = getParent(i);
		while(i!=-1 && data>heapArray[parentIndex])
		{
			swap(heapArray,i,parentIndex);
			i=getParent(i);
		}
	}

	private void resizeHeap() {
		int[] arr_old = new int[capacity];
		System.arraycopy(heapArray, 0, arr_old, 0, capacity);
		heapArray = new int[2*capacity];
		for(int i=0;i<capacity;i++)
			heapArray[i]=arr_old[i];
		capacity=capacity*2;
		arr_old=null;
	}
	
	public static Heap buildHeap(int[] arr)
	{
		Heap heap = new Heap(arr.length,Heap.MAX_HEAP);
		System.arraycopy(arr, 0, heap.heapArray, 0, arr.length);
		int n=arr.length;
		heap.count=n;
		for(int i = (n-1)/2;i>=0;i--)
			heap.heap_Down(i);
		return heap;
	}
	
	public static void main(String[] args) {
		Heap heap =	buildHeap(new int[]{3, 5, 7, 14, 89, 4, 56, 67, 34, 24, 17, 9 , 23});
		for(int i: heap.heapArray)
		{
			System.out.println(i);
		}
		while(heap.count>0)
		System.out.println(heap.deleteMax());
	}
	
}
