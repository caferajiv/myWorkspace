package practice.linkedlist;

import com.data.list.LinkedList;
import com.data.node.Node;

public class ReverseKBlocks {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		list.addLast(9);
		list.addLast(10);
		list.showLinkedList();
		
		int block = 3;
		Node head = reversePartial(list.getHead(),block);
		list.setHead(head);
		list.showLinkedList();
		
		
	}

		
	private static Node reversePartial(Node head, int block) {
		int count = 1;
		Node currentNode = head;
        Node prevNode = null;
		Node temp = new Node();
		while(currentNode!=null && count<block){
			Node nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			temp = nextNode.getNextNode();
			nextNode.setNextNode(currentNode);
			prevNode = nextNode;
			currentNode = temp;
			count++;

		}

		Node temp2 = prevNode;
		prevNode = head;
		head = temp2;
		
		if(currentNode!=null){
			prevNode.setNextNode(reversePartial(currentNode, block));
			
		}


		return head;
	}
	
	private static Node reverse(Node head) {
		
		Node currentNode = head;
		Node prevNode = null;
		Node nextNode = null;
		Node temp = new Node();
		while(currentNode!=null){
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			temp = nextNode.getNextNode();
			nextNode.setNextNode(currentNode);
			prevNode = nextNode;
			currentNode = temp;
			
		}
		return prevNode;
	}
	
	
	

	
	

}
