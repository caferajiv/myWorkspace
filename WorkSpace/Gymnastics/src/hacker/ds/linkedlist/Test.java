package hacker.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Test {
		    

	Node InsertNth(Node head, int data, int position) {
	   Node node = new Node ();
	   node.next = null;
	   node.data = data;
	    
	    if(head == null){
	        head = node;
	        return head;
	    }
	    Node temp = head;
	    int count=0;
	    if(count==position){
	        node.next= head;
	        head = node;
	       return head;
	    }
	    while (temp.next!=null && count!=position){
	        count++;
	        if(count<position){
	            temp = temp.next; 
	        }else {
	            node.next = temp.next;
	            temp.next = node;
	            return head;
	        }
	        
	    }
	    
	    
	    return head;
	    
	    
	}
	
	Node ReverseSingle(Node head) {
		
		if(head == null || head.next == null)
        return head;
    
    Node temp = head;
    Node current = new Node();     
    Node previous = null;
    current = temp;
    
    while(temp.next!=null){
        temp = temp.next;
        current.next = previous;
        previous = current;
        current = temp;

        
    }
    current.next= previous;
    head = current;
    return head;
    
	}
	
	int CompareLists(Node headA, Node headB) {
		
	    // This is a "method-only" submission. 
	    // You only need to complete this method 
		if(headA==null && headB == null)
			return 1;
		
		boolean same = false;
		while(headA !=null && headB != null){
			if(headA.data == headB.data){
				headA = headA.next;
				headB = headB.next;	
			}else 
			{
				return 0;
			}
		}
		if(headA!=null && headB==null || headA==null && headB!=null){
			return 0;
		}
		
		return 1;
	
	}
	//methods not submitted
	
	
	
	
	
	
	
	
	
	Node MergeLists(Node headA, Node headB) {
	     
		if(headA==null && headB!=null){
			return headB;
		}else if(headA!=null && headB == null ){
			return headA;
		}else if(headA==null && headB==null){
			return null;
		}
		Node temp = null;
		if(headA.data<=headB.data){
			temp = headA;
			headA= headA.next;
		}else {
			temp = headB;
			headB = headB.next;
		}
		
		Node save = temp;
		//Node saveB = headB;
		while(headA!=null && headA.next!=null && headB!=null && headB.next!=null){
			while(headA.data<=headB.data){
					temp.next = headA;
					temp = temp.next;
				    headA = headA.next;
				
			}
			while(headB.data<headA.data){
				temp.next = headB;
				temp = temp.next;
				headB = headB.next;
				 
			}
		}
		
		if(headA.data <= headB.data){
			temp.next = headA;
			temp = temp.next;
		    headA = headA.next;
		}else{
			temp.next = headB;
			temp = temp.next;
		    headB = headB.next;
		}
		
		if(headA!=null){
			temp.next = headA;
		}
		if(headB!=null){
			temp.next = headB;
		}

		return save;
	}
	
	int GetNode(Node head,int n) {

		int distance = 0;
		Node aheadNode = head;
		Node hindNode = head; 
		while(aheadNode.next!=null && n>0){
			aheadNode= aheadNode.next;
			n--;
		}
		while(aheadNode.next!=null){
			aheadNode = aheadNode.next;
			hindNode = hindNode.next;
		}
		return hindNode.data;	
	}
	
	Node RemoveDuplicates(Node head) {
		  // This is a "method-only" submission. 
		  // You only need to complete this method. 
		Node back = head;
		Node save = head;
		while(head.next != null){
			//back = head;
			//head = head.next;
			if(head.data == head.next.data){
				head = head.next;
			}else {
				head = head.next;
				back.next=head;
				back = head;
			}
		}
		back.next = null;
		return save;
		}
	
	static boolean  hasCycle(Node head) {
		
		boolean hasCycle = false;
    if(head == null || head.next == null )return false;
		Node slow = head;
		Node fast = head;
               
		while(fast!=null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
			{
				return true;
			}
		}
			
		return hasCycle;	
		}
	
	int FindMergeNode1(Node headA, Node headB) {
	    // Complete this function
	    // Do not write the main method. 
		int data = 0;
		int sizeA = 0;
		int sizeB = 0;
		Set<Node> set = new HashSet<Node>();
		while(headA!=null){
			set.add(headA);
			headA = headA.next;
		}
		
		while(headB!=null && set.add(headB)){
				headB = headB.next;
			}
		if(headB!=null)
		{
			return headB.data;
		}
			
		return data;
	}
	
	int FindMergeNode(Node headA, Node headB) {  //not working
	    // Complete this function
	    // Do not write the main method. 
		int data = 0;
		int sizeA = 0;
		int sizeB = 0;
		
		while(headA!=null){
			sizeA++;
			headA = headA.next;
		}
		
		while(headB!=null){
			sizeB++;
				headB = headB.next;
			}
		int diff = Math.abs(sizeA-sizeB);
		boolean sizeALarger = sizeA>sizeB;
		
		if(sizeALarger){
			while(headA!=null && diff!=0){
				diff--;
				headA= headA.next;
			}
			}else {
				while(headB!=null && diff!=0){
					diff--;
					headB= headB.next;
			}
		}
		
		while(headA!=null && headB!=null){
			if(headA==headB){
				return headA.data;
			}
				
			headA = headA.next;
			headB = headB.next;
		}
			
		return data;
	}
	
	Node SortedInsert(Node head,int data) { //input 2 1 4 3 
		Node node = new Node();
		node.next=null;
		node.data=data;
		node.prev=null;
		
		Node saveNode = head;
		
		if(head == null){
			head = node;
			saveNode = head;
			return saveNode;
		}
		
		if(head.next == null){
			if(node.data<=head.data){
				node.next = head;
				head.prev = node;
				return node;
			}else{
				head.next = node;
				node.prev = head;
				return head;
			}
		}
		
		while(head.next!=null){
			if(node.data<=head.data){
				node.next=head;
				node.prev = head.prev;
				head.prev.next = node;
			    head.prev = node;
			    return saveNode;
			}	
			head = head.next;
		}
		if(head!=null){
			if(node.data<=head.data){
				node.next=head;
				node.prev = head.prev;
				head.prev.next = node;
			    head.prev = node;
			}else{
				head.next = node;
				node.prev = head;
			}
			
			return saveNode;
		}
		
		return saveNode;
	}
	
	Node Reverse(Node head) {
		if(head ==  null){
			return head;
		}
		Node saveNode = head;
		while(head!=null && head.next!=null){
			Node tempNext = head.next;
			//Node tempPrev = head.prev;
			head.next = head.prev;
			head.prev = tempNext;
			head = head.prev;
			
		}
		//Node tempPrev = head.prev;
		head.next = head.prev;
		head.prev = null;
		
		return head;

	}

	

	public static void main(String[] args) {
		Node node1 = new Node(1,null);
		Node node2 = new Node(2,null);
		Node node3 = new Node(3,null);
		Node node4 = new Node(4,null);
		Node node5 = new Node(5,null);
		Node node6 = new Node(3,null);
		node1.next = node2;
		node2.next = node3; 
		node3.next = node4;
		node4.next = node5; 
		node5.next = node6;
		System.out.println(hasCycle(node1));
	}
	
	
	
	static class Node {
	     int data;
	     Node next;
	     Node prev;
	     Node(){
	    	 
	     }
	     Node(int data, Node node){
	    	 this.data = data;
	    	 this.next = node;
	     }
	  }

}
