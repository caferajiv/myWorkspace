package pet;

import java.awt.dnd.DnDConstants;

import com.data.list.DoubleLinkedList;
import com.data.node.DNode;

import tree.BST;
import tree.BST.Node;

public class BSTDLL {
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
		System.out.println();
		
		try {
			convertBST2DLL(bst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void convertBST2DLL(BST bst) {
		DoubleLinkedList DLL = new DoubleLinkedList();
		inOrderTravseral(bst.getRoot(), DLL);
		DNode dNode = DLL.getHead();
		while(dNode!=null) {
			System.out.print(dNode.getItem()+ " ");
			dNode = dNode.getPrevDNode();
		}
		
	}

	private static void inOrderTravseral(Node root, DoubleLinkedList dll) {
		if(root==null) {
			return;
		}
		
		inOrderTravseral(root.getLeftChild(),dll);
		process(root,dll);
		inOrderTravseral(root.getRightChild(),dll);
		
	}

	private static void process(Node node, DoubleLinkedList dll) {
		DNode head = dll.getHead();
		DNode newNode = new DNode(node.getData());
		if(head!=null) {
			head.setNextDNode(newNode);
		}
		newNode.setPrevDNode(head);
		newNode.setNextDNode(null);
		dll.setHead(newNode);
				
	}
	

}
