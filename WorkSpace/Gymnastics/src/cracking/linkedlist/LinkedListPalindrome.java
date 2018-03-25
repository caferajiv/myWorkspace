package cracking.linkedlist;

import java.util.Stack;

import com.data.list.LinkedList;
import com.data.node.Node;


public class LinkedListPalindrome {
	
	public static void main(String[] args) {

		LinkedList evenList = new LinkedList();
		evenList.addLast(1);
		evenList.addLast(2);
		evenList.addLast(3);
		evenList.addLast(4);
		evenList.addLast(5);
		evenList.addLast(5);
		evenList.addLast(4);
		evenList.addLast(3);
		evenList.addLast(2);
		evenList.addLast(1);

		System.out.println();
		evenList.showLinkedList();
		
		System.out.println(isPalindromeStack(evenList));
		
		System.out.println(isPalindromeRecursion(evenList));

		

		LinkedList oddList = new LinkedList();
		oddList.addLast(1);
		oddList.addLast(2);
		oddList.addLast(3);
		oddList.addLast(4);
		oddList.addLast(5);
		oddList.addLast(4);
		oddList.addLast(3);
		oddList.addLast(2);
		oddList.addLast(1);

		System.out.println();
		oddList.showLinkedList();
		
		System.out.println(isPalindromeStack(oddList));
		
		System.out.println(isPalindromeRecursion(oddList));

	}

	private static boolean isPalindromeRecursion(LinkedList list) {
		int size = getSize(list);
		int mid = size/2;
		int count = 1;
		Node head = list.getHead();
		
		return checkPalindome(head, mid, size);
	}

	private static boolean checkPalindome(Node head, int mid, int size) {
		boolean isPalindrome = false;
		if(mid>1) {
			mid--;
			isPalindrome = checkPalindome(head.getNextNode(), mid, size);
			mid++;
		}
		//mid++;
		int data = head.getData();
		int c = mid;
		while(c>0) {
			c--;
		head= head.getNextNode();
		}
		int count = 0;
		if(size%2==0) {
			count = mid-1;
		}else {
			count = mid;
		}
		
		while(count>0) {
			count--;
			head = head.getNextNode();
		}
		if(!(head.getData()==data)) {
			return false;
		}
		return true;
	}

	private static boolean isPalindromeStack(LinkedList list) {
		
		int size = getSize(list);
		int mid = size/2;
		int count = 0;
		Node head = list.getHead();
		Stack<Integer> stack =  new Stack<>();
		while(count<mid) {
			stack.push(head.getData());
			head = head.getNextNode();
			count++;
		}
		if(!(size%2==0)) {
			head = head.getNextNode();
		}
		
		while(!stack.isEmpty()) {
			if(!(stack.pop()==head.getData())) {
				return false;
			}else {
				head = head.getNextNode();
			}
		}
		return true;
		
	}

	private static int getSize(LinkedList list) {
		Node head = list.getHead();
		int size = 0;
		while(head!=null) {
			head = head.getNextNode();
			size++;
		}
		return size;
	}

}
