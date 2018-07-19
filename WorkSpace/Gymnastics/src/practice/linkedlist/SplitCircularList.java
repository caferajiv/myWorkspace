package practice.linkedlist;

import com.data.list.LinkedList;
import com.data.node.Node;

public class SplitCircularList {

	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node18 = new Node(18);
		Node node19 = new Node(19);
		Node node20 = new Node(20);
		Node node21 = new Node(21);
		Node node22 = new Node(22);
		Node node23 = new Node(23);
		Node node24 = new Node(24);
		Node node25 = new Node(25);
	
		
		list.addLast(node1);
		list.addLast(node2);
		list.addLast(node3);
		list.addLast(node4);
		list.addLast(node5);
		list.addLast(node6);
		list.addLast(node7);
		list.addLast(node8);
		list.addLast(node9);
		list.addLast(node10);
		list.addLast(node11);
		list.addLast(node12);
		list.addLast(node13);
		list.addLast(node14);
		list.addLast(node15);
		list.addLast(node16);
		list.addLast(node17);
		list.addLast(node18);
		list.addLast(node19);
		list.addLast(node20);
		list.addLast(node21);
		list.addLast(node22);
		list.addLast(node23);
		list.addLast(node24);
		list.addLast(node25);
		list.addLast(node6);
		
		Node meetingNode =	findMeetingNode(list);
		System.out.println(meetingNode);
		Node cycleStartNode = findStartOfCycle(list, meetingNode); 
		System.out.println(cycleStartNode);
		
		Node midOfCycle = findCycleMid(list, cycleStartNode);
		System.out.println(midOfCycle);
		
		Node endOfCycle = findCycleEnd(list, midOfCycle, cycleStartNode);
		System.out.println(endOfCycle);
		
		Node head2 = midOfCycle.getNextNode();
		midOfCycle.setNextNode(list.getHead());
		endOfCycle.setNextNode(head2);
		
		LinkedList list2= new LinkedList();
		list2.setHead(head2);		
		
		list.showLinkedList();
		list2.showLinkedList();
	}

	private static Node findCycleEnd(LinkedList list, Node midOfCycle, Node cycleStartNode) {
		// TODO Auto-generated method stub
		Node slowPtr = midOfCycle;
		while(slowPtr.getNextNode()!=cycleStartNode){
			slowPtr = slowPtr.getNextNode();
		}
		return slowPtr;
	}

	private static Node findCycleMid(LinkedList list, Node cycleStartNode) {
		// TODO Auto-generated method stub
		Node midOfCycle = null;
		Node slowPtr = cycleStartNode;
		Node fastPtr = cycleStartNode;
		slowPtr = slowPtr.getNextNode();
		fastPtr = fastPtr.getNextNode().getNextNode();
		while(fastPtr!=cycleStartNode && fastPtr.getNextNode()!=cycleStartNode ){
			slowPtr=slowPtr.getNextNode();
			fastPtr = fastPtr.getNextNode().getNextNode();
		}
		
		return slowPtr;
	}

	private static Node findStartOfCycle(LinkedList list, Node meetingNode) {
		// TODO Auto-generated method stub
		
		Node slowPtr = list.getHead();
		Node fastPtr = meetingNode;
		while(slowPtr!=fastPtr)
		{
			slowPtr = slowPtr.getNextNode();
			fastPtr = fastPtr.getNextNode();
		}
		return slowPtr;
	}

	private static Node findMeetingNode(LinkedList list) {
		// TODO Auto-generated method stub
		
		Node head = list.getHead();
		Node slowPtr = head;
		Node fastPtr = head;
		slowPtr = slowPtr.getNextNode();
		fastPtr = fastPtr.getNextNode().getNextNode();
		while(fastPtr!=slowPtr && slowPtr.getNextNode()!=null && fastPtr.getNextNode()!=null && fastPtr.getNextNode().getNextNode()!=null){
			slowPtr=slowPtr.getNextNode();
			fastPtr = fastPtr.getNextNode().getNextNode();
		}
		return slowPtr;
	}

}
