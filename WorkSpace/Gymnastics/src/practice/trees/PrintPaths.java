package practice.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.data.node.TNode;
import com.data.tree.BinarySearchTree;

public class PrintPaths {
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
		
		List<TNode> list = new ArrayList<>();
		printPaths(bsTree.getRoot(),list);
	}

	private static void printPaths(TNode root, List<TNode> list) {
		// TODO Auto-generated method stub
		List<TNode> list1 = new ArrayList<>();
		for(TNode node : list){
			list1.add(node);
		}
		
		if(root!=null){
			list1.add(root);
			
			if(root.getLeftChild()!=null){
				printPaths(root.getLeftChild(), list1);
			}
			if(root.getRightChild()!=null){
				printPaths(root.getRightChild(), list1);
			}
			if(root.getLeftChild()==null && root.getRightChild()==null)
			printList(list1);
			
		}
		
	}

	private static void printList(List<TNode> list) {
		// TODO Auto-generated method stub
		System.out.println();
		for(TNode node : list) {
			
			System.out.print(node.getData()+ " ");
		}
		
	}

}
