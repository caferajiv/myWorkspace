package hacker.crackingcodinginterview;

public class ListCycle {
	
	//A Node is defined as: 
	    class Node {
	        int data;
	        Node next;
	    }
	

	boolean hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while(slow!=null && fast!=null && fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) return true;
		}
		
		return false;

	}

}
