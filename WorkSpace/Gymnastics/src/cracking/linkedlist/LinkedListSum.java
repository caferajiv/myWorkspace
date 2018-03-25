package cracking.linkedlist;

import java.util.Stack;

import com.data.list.LinkedList;
import com.data.node.Node;

public class LinkedListSum {
	
	public static void main(String[] args) {

		//calc 617+295 = 912  
		// list is stored backwards.
		LinkedList backlist1 = new LinkedList();
		backlist1.addLast(7);
		backlist1.addLast(1);
		backlist1.addLast(6);
		
		LinkedList backlist2 = new LinkedList();
		backlist2.addLast(5);
		backlist2.addLast(9);
		backlist2.addLast(2);
		
		backlist1.showLinkedList();
		backlist2.showLinkedList();
		
		
		LinkedList list3 = addBackwards(backlist1.getHead(), backlist2.getHead());
		list3.showLinkedList();
		
		LinkedList forlist1 = new LinkedList();
		forlist1.addLast(6);
		forlist1.addLast(1);
		forlist1.addLast(7);
		
		LinkedList forlist2 = new LinkedList();
		forlist2.addLast(2);
		forlist2.addLast(9);
		forlist2.addLast(5);
		
		forlist1.showLinkedList();
		forlist2.showLinkedList();
		
		LinkedList list4 = addForwardsStack(forlist1.getHead(), forlist2.getHead());
		list4.showLinkedList();
		
		
		forlist1.showLinkedList();
		forlist2.showLinkedList();
		LinkedList list5 = addForwardsRecursion(forlist1, forlist2);
		list5.showLinkedList();
		
		
	
	
	}

	private static LinkedList addForwardsRecursion(LinkedList list1, LinkedList list2) {
		// add zeroes in front of list that is smaller
		Node head = list1.getHead();
		Node head2 = list2.getHead();
		
		int size1 = getSize(head);
		int size2 = getSize(head2);
		int absDiff = Math.abs(size1-size2);
		if(size1 > size2) {
			while(absDiff>0) {
				list2.addFirst(0);
				absDiff--;
			}
		}else  if(size2>size1) {
			while(absDiff>0) {
				list1.addFirst(0);
				absDiff--;
			}
			
		}
		
		LinkedList list = new LinkedList();
		int sum = 0;
		int carry = 0;
		
		calculate(head,head2,list,carry);
				
		return list;
	}

	private static int getSize(Node head) {
		int size =0;
		while(head!=null) {
			head= head.getNextNode();
			size++;
		}
		return size;
	}


	private static int  calculate(Node head, Node head2, LinkedList list, int carry) {
		
		if(head.getNextNode()!=null && head2.getNextNode()!=null) {
			carry = calculate(head.getNextNode(), head2.getNextNode(), list, carry);
		}
		
		int sum = carry + head.getData() + head2.getData();
		list.addLast(sum%10);
		carry = sum/10;
		return carry;
		
	}

	private static LinkedList addForwardsStack(Node head, Node head2) {
		LinkedList list = new LinkedList();
		Stack<Integer> stack1 = new Stack();
		while(head!=null) {
			stack1.push(head.getData());
			head = head.getNextNode();
		}
		Stack<Integer> stack2 = new Stack();
		while(head2!=null) {
			stack2.push(head2.getData());
			head2 = head2.getNextNode();
		}
		int sum=0;
		int carry = 0;
		
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			sum = carry + stack1.pop() + stack2.pop();
			list.addLast(sum%10);
			carry = sum/10;
		}
		
		while(!stack1.isEmpty()) {
			sum = carry + stack1.pop();
			list.addLast(sum%10);
			carry = sum/10;
		}
		
		while(!stack2.isEmpty()) {
			sum = carry + stack2.pop();
			list.addLast(sum%10);
			carry = sum/10;
		}
		
		return list;
	}

	private static LinkedList addBackwards(Node head1, Node head2) {
		LinkedList list = new LinkedList();
		int carry = 0;
		int sum = 0;
		while(head1!=null && head2!=null) {
			int first = head1.getData();
			int second = head2.getData();
			sum = carry+first+second;
			int val = sum%10;
			carry = sum/10;
			list.addLast(val);
			head1 = head1.getNextNode();
			head2 = head2.getNextNode();
		}
		
		return list;
	}

}
