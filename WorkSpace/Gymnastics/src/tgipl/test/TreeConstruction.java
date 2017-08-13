package tgipl.test;

public class TreeConstruction {
	
	static int preIndex=0;
	
	public static void main(String[] args) {
		String infixString = "A+B*C-D*E+F";// "((2+8)*9)-(5*(5+2))";
		String prefixString = "-*+ABC*D+EF";// "-*+289*5+52";
		
		//String infixString = "DBEAFC";// "((2+8)*9)-(5*(5+2))";
		//String prefixString = "ABDECF";// "-*+289*5+52";

		constructTree(infixString, prefixString);

	}

	private static BinaryTreeNode constructTree(String infixString,
			String prefixString) {
		
		int start=0;
		int end = infixString.length()-1; 
		
		BinaryTreeNode bNode=buildBinaryTree(infixString.toCharArray(),prefixString.toCharArray(), start, end);
		

		BinaryTreeNode.preOrder(bNode);
		return bNode;
	}
	
	private static BinaryTreeNode buildBinaryTree(char[] infix,
			char[] prefix, int start, int end) {
		
		BinaryTreeNode newNode= new BinaryTreeNode();
		if(start>end) return null;
		newNode.setData(prefix[preIndex]);
		preIndex++;
		if(start==end)return newNode;
		
		//find index of the rootnode in infix and split the infix array into 
		//left and right sub trees
		int inIndex=search(infix,start, end, newNode.getData());
		//construct left and right sub trees
		newNode.setLeftChild(buildBinaryTree(infix, prefix, start, inIndex-1));
		
		newNode.setRightChild(buildBinaryTree(infix, prefix, inIndex+1, end));
		
		return newNode;
	}

	private static int search(char[] infix, int start, int end, char data) {
		for(int i=start; i<=end;i++)
		{
			if(infix[i]==data)return i;
		}
		return -1;
	}

	static class BinaryTreeNode{
		
		BinaryTreeNode leftChild;
		/**
		 * @return the leftChild
		 */
		public BinaryTreeNode getLeftChild() {
			return leftChild;
		}
		/**
		 * @param leftChild the leftChild to set
		 */
		public void setLeftChild(BinaryTreeNode leftChild) {
			this.leftChild = leftChild;
		}
		/**
		 * @return the rightChild
		 */
		public BinaryTreeNode getRightChild() {
			return rightChild;
		}
		/**
		 * @param rightChild the rightChild to set
		 */
		public void setRightChild(BinaryTreeNode rightChild) {
			this.rightChild = rightChild;
		}
		/**
		 * @return the data
		 */
		public char getData() {
			return data;
		}
		/**
		 * @param data the data to set
		 */
		public void setData(char data) {
			this.data = data;
		}
		BinaryTreeNode rightChild;
		char data;
		
		public static void preOrder(BinaryTreeNode node)
		{
			if(node!=null)
			{
				System.out.print(node.data + " ");
			}
			if(node.leftChild!=null)
			{
				preOrder(node.leftChild);
			}
			if(node.rightChild!=null)
			{
				preOrder(node.rightChild);
			}
		}
		
	}
	
	

}
