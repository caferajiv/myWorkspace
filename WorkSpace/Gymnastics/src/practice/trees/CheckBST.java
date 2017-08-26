package practice.trees;

import java.util.ArrayList;
import java.util.List;

import com.data.node.TNode;
import com.data.tree.BinarySearchTree;

import node.TreeNode;
import tree.BinaryTree;

public class CheckBST {
	public static void main(String[] args) {

		BinarySearchTree bsTree= new BinarySearchTree();
		bsTree.addChild(1);
		bsTree.addChild(4);
		bsTree.addChild(5);
		bsTree.addChild(2);
		bsTree.addChild(7);
		bsTree.addChild(3);
		bsTree.addChild(6);
		bsTree.addChild(9);
		bsTree.addChild(8);
		bsTree.inOrderTraversal();
		
		BinaryTree bTree = new BinaryTree();
		bTree.addChildBalanced(1);
		bTree.addChildBalanced(4);
		bTree.addChildBalanced(5);
		bTree.addChildBalanced(2);
		bTree.addChildBalanced(7);
		bTree.addChildBalanced(3);
		bTree.addChildBalanced(6);
		bTree.addChildBalanced(9);
		bTree.addChildBalanced(8);
		bTree.InorderTraversal(bTree.getRoot());
	
		//System.out.println(checkIsBST(bsTree.getRoot()));
	
	}
	
	private static boolean checkIsBST(TreeNode root) {
		if(root==null || (root.getLeftChild()==null && root.getRightChild()==null)) return true;
		
		boolean left = false;
		boolean right = false;
		if(root.getLeftChild()==null) left = true;
		if(root.getRightChild()==null) right = true;
		if(root.getLeftChild()!=null && root.getLeftChild().getData()<root.getData()) left = true;
		
		if(root.getRightChild()!=null && root.getRightChild().getData()>root.getData()) right = true;
		
	    if(checkIsBST(root.getLeftChild()) && checkIsBST(root.getRightChild()) && left && right) return true;
		
		return false;
	}

	private static boolean checkIsBST(TNode root) {
		if(root==null || (root.getLeftChild()==null && root.getRightChild()==null)) return true;
		
		boolean left = false;
		boolean right = false;
		if(root.getLeftChild()==null) left = true;
		if(root.getRightChild()==null) right = true;
		if(root.getLeftChild()!=null && maxOfLeftSubTree(root)<root.getData()) left = true;
		
		if(root.getRightChild()!=null && minOfRightSubTree(root)>root.getData()) right = true;
		
	    if(checkIsBST(root.getLeftChild()) && checkIsBST(root.getRightChild()) && left && right) return true;
		
		return false;
	}

	private static int minOfRightSubTree(TNode root) {
		TNode node = root.getRightChild();
		while(node.getLeftChild()!=null){
			node =node.getLeftChild();
		}
		return node.getData();
	}

	private static int maxOfLeftSubTree(TNode root) {
		TNode node = root.getLeftChild();
		while(node.getRightChild()!=null){
			node =node.getRightChild();
		}
		return node.getData();
	}

}
