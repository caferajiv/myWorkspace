package practice.search.sort;

import com.data.list.LinkedList;
import com.data.node.Node;

import sort.MergeSort;

public class MergeSortLinkedList {

	// static int[] arr2;

	public static void main(String[] args) {

		int[] arr = { 130, 3, 235, 36, 78, 0, 11, 125, 10, 144, 19, 78 };

		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.print("\n" + arr.length);
		System.out.println("\n" + arr[(arr.length-1-0)/2]);

		int[] arr2 = new int[arr.length];

		int low = 0;
		int high = arr.length - 1;
		 MergeSort.mergesort(arr,arr2,low,high);

		 for(int i: arr2){
		 System.out.print(i+" ");
		 }

		LinkedList list = new LinkedList();

		list.addLast(130);
		list.addLast(3);
		list.addLast(235);
		list.addLast(36);
		list.addLast(78);
		list.addLast(0);
		list.addLast(11);
		list.addLast(125);
		list.addLast(10);
		list.addLast(144);
		list.addLast(19);
		list.addLast(78);
		
		System.out.println();
		list.showLinkedList();

		// list.setHead(head);
		int size = getSize(list);
		System.out.println(size);
		Node mid = getMidNode(list);
		System.out.println(mid);
		Node last = getLastNode(list);
		System.out.println(last);
		System.out.println();
		LinkedList temp = new LinkedList();

		mergeSort(list, temp,  0, size-1);
		
		temp.showLinkedList();

	}

	private static void mergeSort(LinkedList list, LinkedList temp, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(list, temp, low, mid);
			mergeSort(list, temp, mid + 1, high);
			merge(list, temp, low, mid + 1, high);
		}
	}

	

	private static void merge(LinkedList list, LinkedList temp, int low, int mid, int high) {

		int i = low;
		int lo = low;
		int hi = high;
		int mi = mid;
		int size = high - low + 1;

		while (lo <= mid -1 && mi <= high) {
			if (getNodeAt(list, lo).getData() <= getNodeAt(list, mid).getData()) {
				int data = getNodeAt(list, lo).getData();
				setDataAt(temp,i,data);
				i++;
				lo++;
			} else {
				int data = getNodeAt(list, mi).getData();
				setDataAt(temp,i,data);
				i++;
				mi++;
			}
		}

		while (lo <= mid - 1) {
			int data = getNodeAt(list, lo).getData();
			setDataAt(temp,i,data);
			i++;
			lo++;
		}
		while (mi <= high) {
			int data = getNodeAt(list, mi).getData();
			setDataAt(temp,i,data);
			i++;
			mi++;
		}

		for (int j = 0; j < size; j++) {
			int data = getNodeAt(list, high).getData();
			setDataAt(temp,i,data);
			high--;
		}
	}

	private static Node getLastNode(LinkedList list) {
		Node head = list.getHead();
		while (head.getNextNode() != null) {
			head = head.getNextNode();
		}
		return head;
	}

	private static Node getMidNode(LinkedList list) {
		Node slow = list.getHead();
		Node fast = list.getHead();
		while (fast != null && fast.getNextNode() != null && fast.getNextNode().getNextNode()!=null) {
			fast = fast.getNextNode().getNextNode();
			slow = slow.getNextNode();
		}
		return slow;
	}

	private static int getSize(LinkedList list) {
		int count = 0;
		Node head = list.getHead();
		while (head != null) {
			head = head.getNextNode();
			count++;
		}
		return count;
	}
	
	private static Node getNodeAt(LinkedList list , int index){
		int count = 0;
		Node head = list.getHead();
		while(head!=null && count < index) {
			head = head.getNextNode();
			count++;
		}
		return head;
	}
	private static void setDataAt(LinkedList list , int index, int data){
		int count = 0;
		Node head = list.getHead();
		while(head!=null && count < index) {
			head = head.getNextNode();
			count++;
		}
		
		if(count<index) {
			list.addLast(data);
		}else if(count==index) {
			if(head==null) {
				list.addFirst(data);
			}else {
				head.setData(data);
			}
		}
	}

}
