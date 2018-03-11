package pet;

import com.data.node.Node;

import tree.BST;

public class PrintPaths {
	public static void main(String[] args) {

		int[] paths  = new int[100];

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
			printPaths(bst.getRoot(),paths,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}

	private static void printPaths(BST.Node<Integer> root, int[] paths, int index) {
		if(root==null) {
			//print(paths,index);
			return;
		}else {
			paths[index] = root.getData();
			index++;
			if(root.getLeftChild()==null && root.getRightChild()==null) {
				print(paths, index);
			}
			printPaths(root.getLeftChild(), paths, index);
			printPaths(root.getRightChild(), paths, index);
		}
		

		
	}

	private static void print(int[] paths, int index) {
		for(int i=0; i<index;i++) {
			System.out.print(paths[i]+" ");
		}
		System.out.println();
		
	}

}
