package practice.trees;

import node.TreeNode;
import tree.BinaryTree;

public class BSTFromInOrderAndPreOrder {
	
	public static int  preIndex = 0;

	public static void main(String[] args) {

		int[] inOrder = { 4, 2, 5, 1, 6, 3 };
		int[] preOrder = { 1, 2, 4, 5, 3, 6 };

		BinaryTree bTree = new BinaryTree();
		bTree.setRoot(createBTNode(inOrder, preOrder, 0, inOrder.length - 1));
		bTree.InorderTraversal(bTree.getRoot());

	}

	private static TreeNode createBTNode(int[] inOrder, int[] preOrder, int min, int max) {
		if (min < 0 || max >= inOrder.length || min > max)
			return null;
		TreeNode node = new TreeNode(preOrder[preIndex]);
		if (preIndex < preOrder.length - 1) {
			int index = findPreIndexinInorder(inOrder, preOrder, preIndex, min, max);
			if (index != -1) {
				preIndex++;
				node.setLeftChild(createBTNode(inOrder, preOrder, min, index - 1));

				node.setRightChild(createBTNode(inOrder, preOrder, index + 1, max));
			}
		}

		return node;
	}

	private static int findPreIndexinInorder(int[] inOrder, int[] preOrder, int preIndex, int min, int max) {
		for (int i = min; i <= max; i++) {
			if (preOrder[preIndex] == inOrder[i]) {
				return i;
			}
		}
		return -1;
	}

}
