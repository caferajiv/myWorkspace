package pet;


import com.data.list.LinkedList;
import com.data.node.Node;

public class ReverseLinkedList {
	
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
		
		reverseList(list);
		
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
		
	}


