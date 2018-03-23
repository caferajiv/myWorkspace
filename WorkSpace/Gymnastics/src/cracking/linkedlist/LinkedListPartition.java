package cracking.linkedlist;

import com.data.list.LinkedList;
import com.data.node.Node;

public class LinkedListPartition {
	
	public static void main(String[] args) {
		
		int[] arr =  {11, 2, 31, 4, 5, 18, 8, 91, 3, 6};
		partition(arr,0,arr.length-1);
		
		System.out.println();
		for(int i : arr) {
		System.out.print(i+ " ");
		}

		LinkedList list = new LinkedList();
		list.addLast(11);
		list.addLast(2);
		list.addLast(31);
		list.addLast(4);
		list.addLast(5);
		list.addLast(18);
		list.addLast(8);
		list.addLast(91);
		list.addLast(3);
		list.addLast(6);
		
		System.out.println();
		list.showLinkedList();
		
		partition(list.getHead());
		
		list.showLinkedList();
		
	
	}
	
	
	private static int partition(int[] a, int low, int high) {
		int start=low;
		int end=high;
		int pivot=low;
		
		int pivotElement=a[pivot];
		System.out.println(pivotElement);
		while(start<end)
		{
			while(start<=end && a[start]<=pivotElement)
			{
				start++;
			}
			while(start<=end && a[end]>pivotElement)
			{
				end--;
			}
			if(start<end){
				swap(a,start,end);
			}
		}
		a[pivot]=a[end];
		a[end]=pivotElement;
		System.out.println(end);
		return end;
	}
	
	private static void swap(int []arr, int i , int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
	}

	private static void partition(Node head) {
		
		int low = 0;
		int high = getSize(head)-1;
		int pivot = findPartition(head, low, high);
	}

	private static int findPartition(Node head, int low, int high) {
		int lo = low;
		int hi = high;
		int pivot = low;
		Node pivotNode = getNodeAt(head, pivot);
		int pivotItem = pivotNode.getData();
		System.out.println(pivotItem);
		while(lo < hi) {
			while(lo <= hi && getNodeAt(head, lo).getData() <= pivotItem) {
				lo++;
			}
			
			while(lo <= hi && getNodeAt(head, hi).getData() > pivotItem) {
				hi--;
			}
			
			if(lo<hi) {
				swapList(head, lo, hi);
			}
		}
		
		int hiData = getNodeAt(head, hi).getData();
		System.out.println(hiData);
		pivotNode.setData(hiData);
		getNodeAt(head, hi).setData(pivotItem);
		System.out.println(hi);
		return hi;
		
	}

	private static void swapList(Node head, int lo, int hi) {
		
		int loData = getNodeAt(head, lo).getData();
		int hiData = getNodeAt(head, hi).getData();
		getNodeAt(head, lo).setData(hiData);
		getNodeAt(head, hi).setData(loData);
				
	}

	private static Node getNodeAt(Node head, int index) {
		int i = 0;
		while(head!=null && i < index) {
			head = head.getNextNode();
			i++;
		}
		return head;
	}

	private static int getSize(Node head) {
		int size = 0;
		while(head!=null) {
			head = head.getNextNode();
			size++;
		}
		return size;
	}

}
