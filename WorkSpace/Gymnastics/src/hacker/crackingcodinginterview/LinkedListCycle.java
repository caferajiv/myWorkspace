package hacker.crackingcodinginterview;

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:  
  
*/
    public class LinkedListCycle {
    	
    	  class Node {
    	        int data;
    	        Node next;
    	    }
    	
    	boolean hasCycle(Node head) {
    	    if(head!=null && head.next!=null && head.next.next !=null){
    	         Node slowPtr = head;
    	         Node fastPtr = head.next.next;
    	        while(fastPtr.next!=null && fastPtr.next.next!=null && slowPtr!=fastPtr){
    	            slowPtr = slowPtr.next;
    	            fastPtr = fastPtr.next.next;
    	        }
    	        if(slowPtr==fastPtr){
    	            return true;
    	        }
    	        return false;
    	    }
    	   return false;

    	}
    	
    }

