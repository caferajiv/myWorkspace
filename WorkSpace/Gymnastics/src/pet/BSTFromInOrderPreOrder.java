package pet;

import node.TreeNode;
import tree.BinaryTree;

public class BSTFromInOrderPreOrder {
	
	static int preIndex = 0;
	public static void main(String[] args) {

		int[] inOrder = { 4, 2, 5, 1, 6, 3 };
		int[] preOrder = { 1, 2, 4, 5, 3, 6 };

		BinaryTree bTree = new BinaryTree();
		bTree.setRoot(createBTNode(inOrder, preOrder, 0, inOrder.length - 1));
		bTree.InorderTraversal(bTree.getRoot());

	
		
	}

	private static TreeNode createBTNode(int[] inOrder, int[] preOrder, int i, int j) {
		if(i<0 || j>=inOrder.length || preIndex>=preOrder.length || i>j) return null;
		
		TreeNode root = new TreeNode(preOrder[preIndex]);
		if (preIndex < preOrder.length - 1) {
		int inIndex = findElementAtPreIndexInInorder(inOrder,preOrder, i,j);
		
		if(inIndex!=-1) {
			preIndex++;
		root.setLeftChild(createBTNode(inOrder, preOrder, i, inIndex-1));
		root.setRightChild(createBTNode(inOrder, preOrder, inIndex+1, j));
		}
		}
		
		return root;
	}

	private static int findElementAtPreIndexInInorder(int[] inOrder, int[] preOrder, int low, int high) {
		for (int i = low; i <= high; i++) {
			if (preOrder[preIndex] == inOrder[i]) {
				return i;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] inOrder, int low, int high, int n) {
		if(low<high) {
			int mid = low+ (high-low)/2;
			if(inOrder[mid] == n) return mid;
			
			if(inOrder[mid]>n)
				return binarySearch(inOrder,0,mid-1,n);
			else
				return binarySearch(inOrder,mid+1,high,n);
		}
		return -1;
	}

}
