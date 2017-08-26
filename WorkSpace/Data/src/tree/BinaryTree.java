package tree;

import java.util.concurrent.ArrayBlockingQueue;

import node.TreeNode;

public class BinaryTree {
	
	/**
	 * @return the root
	 */
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	private TreeNode root;
	private int count;
	
	public void addChild(int data)
	{
		if(root==null){
		TreeNode node = new TreeNode(data);
		root=node;
		}else{
			TreeNode node = new TreeNode();
			node = root;
		while(node!=null)
		{
			if(node.getLeftChild()==null){
				node.setLeftChild(new TreeNode(data));
				return;
			}else if(node.getRightChild()==null){
				node.setRightChild(new TreeNode(data));
				return;
			}else if(node.getLeftChild()!=null && node.getRightChild()!=null){
				node = node.getLeftChild();
			}
			
			
		}
	}
		
	}
	public void addChildBalanced(int data){

		if(root==null){
		TreeNode node = new TreeNode(data);
		root=node;
		} else {
			TreeNode node = new TreeNode();
			node = root;
			ArrayBlockingQueue<TreeNode> Q = new ArrayBlockingQueue<TreeNode>(10);
			Q.offer(node);
			while (Q.peek() != null) {
				TreeNode tnode = Q.poll();
				if(tnode.getLeftChild()!=null) Q.offer(tnode.getLeftChild());
				if(tnode.getRightChild()!=null) Q.offer(tnode.getRightChild());
				if (tnode.getLeftChild() == null) {
					TreeNode newNode = new TreeNode(data);
					tnode.setLeftChild(newNode);
					Q.offer(newNode);
					return;
				} else if (tnode.getRightChild() == null) {

					TreeNode newNode = new TreeNode(data);
					tnode.setRightChild(newNode);
					Q.offer(newNode);
					return;
				}
			}
		}
		
	}
	
	
	public void deleteChild(int data)
	{
		while(root!=null)
		{
			if(root.getData()==data)
			{ count--;
				if(root.getLeftChild()!=null)
				{
					root=root.getLeftChild();
					
				}else if(root.getRightChild()!=null)
				{
					root=root.getRightChild();
					
				}
				else
				{
					root=null;
					
				}
			}
			else
			{
				if(root.getLeftChild()!=null)
				{
					root=root.getLeftChild();
				}
				else if(root.getRightChild()!=null)
				{
					root= root.getRightChild();
				}
			}
		}
	}
	
	public void InorderTraversal(TreeNode node)
	{
		if(node!=null)
		{
			InorderTraversal(node.getLeftChild());
			System.out.print(node + " ");
			InorderTraversal(node.getRightChild());
			
		}
	}
	
	public void PreorderTraversal(TreeNode node)
	{
		if(node!=null)
		{
			System.out.println(node);
			PreorderTraversal(node.getLeftChild());
			PreorderTraversal(node.getRightChild());
			
		}
	}
	
	public void PostorderTraversal(TreeNode node)
	{
		if(node!=null)
		{
			PostorderTraversal(node.getLeftChild());
			PostorderTraversal(node.getRightChild());
			System.out.println(node);
			
		}
	}
	
	public void LevelorderTraversal(TreeNode node)
	{
		if(root==null) return;
		ArrayBlockingQueue<TreeNode> Q = new ArrayBlockingQueue<TreeNode>(count);
		if(root!=null)
		{
			Q.offer(root);
		}
		while(Q.peek()!=null)
		{
			TreeNode tnode = Q.poll();
			System.out.println(tnode);
			if(tnode.getLeftChild()!=null)
			{
				Q.offer(tnode.getLeftChild());
				Q.offer(tnode.getRightChild());
			}
		}
	}

}
