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
	
		System.out.println(checkBST(bTree.getRoot()));
	
	}
	
	
	 private static boolean checkBST (TreeNode root)
	    { 
	        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	    }

	  private static  boolean check(TreeNode root, int min, int max){
	        if (root == null)
	            return true;
	        
	        if(root.getData() <= min || root.getData() >= max) return false;
	        
	        return check(root.getLeftChild(), min, root.getData()) && check(root.getRightChild(), root.getData(), max);
	    }
	
	

	

	

}
