package pet;

import tree.BST;
import tree.BST.Node;

public class PrintPathTree {
	
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
			System.out.println();
			printPaths(bst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}

	private static void printPaths(BST bst) {
		
		Node[] path = new Node[20];
		int index =0;
		
		printPath(bst.getRoot(),path, index);
		
	}

	private static void printPath(Node node, Node[] path, int index) {
		
		if(node.getLeftChild()==null && node.getRightChild()==null){
			path[index]=node;
			print(path, index);
		}else
		{
			path[index] = node;
			index++;
			if(node.getLeftChild()!=null){
				printPath(node.getLeftChild(), path, index);
			}
			if(node.getRightChild()!=null){
				printPath(node.getRightChild(), path, index);
			}
			
		}
		
	}

	private static void print(Node[] path, int index) {
		
		for(int i=0;i<=index;i++){
			System.out.print(path[i]);
		}
		System.out.println();
	}

}
