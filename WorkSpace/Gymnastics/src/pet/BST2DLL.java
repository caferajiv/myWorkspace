package pet;

import com.data.list.DoubleLinkedList;
import com.data.node.DNode;

import tree.BST;
import tree.BST.Node;

public class BST2DLL {
	public static void main(String[] args) {

		BST bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(5);
		bst.insert(1);
		bst.insert(6);
		bst.insert(3);
		bst.insert(7);
		
		bst.inOrderTraversal();
		
		try {
			convertBST2DLL(bst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	private static void convertBST2DLL(BST bst) {
		DoubleLinkedList DLL = new DoubleLinkedList(new DNode());
	
		inOrderHelper(bst.getRoot(), DLL);
		
		if(DLL.getHead()!=null && DLL.getHead().getNextDNode()==null){
			while(DLL.getHead().getPrevDNode()!=null){
				DNode node = DLL.getHead();
				System.out.println((Node)node.getItem());
				DLL.setHead(node.getPrevDNode());
			}
		}
	}
	private static void inOrderHelper(Node r , DoubleLinkedList dll)
	   {
	      if (r != null)
	      {
	         inOrderHelper(r.getLeftChild(),dll);
	         process(r,dll);
	         inOrderHelper(r.getRightChild(),dll);
	      }
	   }

	private static void process(Node r, DoubleLinkedList dll) {
		
		if(r!=null){
			DNode head = dll.getHead(); 
			DNode newNode = new DNode(r);
			newNode.setPrevDNode(head);
			newNode.setNextDNode(null);
			head.setNextDNode(newNode);
			dll.setHead(newNode);
			
		}
		
		
		
	}

}
