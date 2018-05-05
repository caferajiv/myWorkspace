package pet;


import com.data.list.LinkedList;
import com.data.node.Node;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		//list.addLast(5);
		//list.addLast(7);
		//list.addLast(8);
		//list.addLast(9);
		//list.addLast(8);
		//list.addLast(2);
		//list.addLast(5);
		//list.addLast(8);
		//list.addLast(4);
		//list.addLast(7);
		//list.addLast(8);
		//list.addLast(0);
		
		
		
		list.showLinkedList();
		
		Node head = reverseAlternatePair(list.getHead(),2);
		list.setHead(head);
		list.showLinkedList();
		
		
		}

	private static void reverseList(LinkedList list) {
		
		Node head = list.getHead();
		Node backNode = null;
		Node nextNode = null;
		
		while(head.getNextNode()!=null){
			//nextNode = new Node();
			//nextNode.setData(head.getData());
			//if(head.getNextNode()!=null){
				nextNode=head.getNextNode();
				head.setNextNode(backNode);
				backNode = head;
				//System.out.println(head.getData());
				head = nextNode;
				//head.setNextNode(nextNode.getNextNode());
				//head.setData(nextNode.getData());
				
			//}else{
			//	head.setNextNode(backNode);
			//}
			
			//nextNode = nextNode.getNextNode();
		}
		head.setNextNode(backNode);
		list.setHead(head);
		
	}
	
	private static Node reverseSimple(Node head) {
		//Node head = list.getHead();
		Node temp = null;
		while(head !=null) {
			Node nextNode = head.getNextNode();
			head.setNextNode(temp);
			temp = head;
			head = nextNode;
		}
		
		//list.setHead(temp);
		return temp;
	} 
	
	//1-2-3-4
	//2-1-4-3
	private static Node reverseAlternatePair(Node head, int k) {
		
		int count = k;
		Node temp = null;
		Node nextNode = null;
		while(head !=null && count>0) {
			nextNode = head.getNextNode();
			head.setNextNode(temp);
			temp = head;
			head = nextNode;
			count--;
		}
		System.out.println(temp.getData());
		while(temp.getNextNode()!=null) {
			temp = temp.getNextNode();
		}
		System.out.println(temp.getData());
		//System.out.println(nextNode.getData());
		if(nextNode!=null) {
			temp.setNextNode(reverseAlternatePair(nextNode,k));
		}
		
		//list.setHead(temp);
		return temp;
	} 
		
	
	
	private static void removeOdds(LinkedList list) {
		Node head = list.getHead();
		Node temp = null;
		Node current = head;
		int count =0;
		while(current!=null) {
			if(current.getData()%2==0) {
				if(count==0) {
					count++;
					head = current;
					temp = head;
				}else {
					head.setNextNode(current);
					head = head.getNextNode();
				}
			}
			current = current.getNextNode();
		}
		
		head.setNextNode(null);
		list.setHead(temp);
	}
		
	}


