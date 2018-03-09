package pet;
import com.data.list.LinkedList;
import com.data.node.Node;

public class ReverseKNodes {
	
	public static void main(String[] args) {

		
		LinkedList list = new LinkedList();
		list.addLast(9);
		list.addLast(3);
		list.addLast(3);
		list.addLast(6);
		list.addLast(2);
		list.addLast(5);
		list.addLast(8);
		list.addLast(4);
		list.addLast(7);
		list.addLast(8);
		list.addLast(0);
		
		
		
		list.showLinkedList();
		Node head = list.getHead();
		//head = reverseList(head);
		int k = 3;
		
		head = reverseKNodes(head,k-1);
		list.setHead(head);
		
		list.showLinkedList();
		
	}

	private static Node reverseKNodes(Node head, int k) {

		int count = k;
		
		Node nextNode = head.getNextNode();
		Node saveNode = null;
		Node tempNode = head;
		while(nextNode!=null && count>0) {
			tempNode.setNextNode(saveNode);
			saveNode = tempNode;
			tempNode = nextNode;
			//if(nextNode.getNextNode()!=null)
			nextNode= nextNode.getNextNode();
			count--;
			
		}
		tempNode.setNextNode(saveNode);
		saveNode = tempNode;
		while(saveNode.getNextNode()!=null) {
			saveNode = saveNode.getNextNode();
		}
		if(nextNode!=null) {
			saveNode.setNextNode(reverseKNodes(nextNode, k));
		}
		return tempNode;
	
		
	}

	private static Node reverseList(Node head) {

		Node nextNode = head.getNextNode();
		Node saveNode = null;
		Node tempNode = head;
		while(nextNode!=null) {
			tempNode.setNextNode(saveNode);
			saveNode = tempNode;
			tempNode = nextNode;
			//if(nextNode.getNextNode()!=null)
			nextNode= nextNode.getNextNode();
			
		}
		tempNode.setNextNode(saveNode);
		saveNode = tempNode;
		return tempNode;
	}

}
