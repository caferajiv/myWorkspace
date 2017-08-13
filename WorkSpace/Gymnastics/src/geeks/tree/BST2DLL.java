package geeks.tree;





public class BST2DLL {
	
	public static void main(String[] args) {
		
	}
	
	
	public Node Convert(Node root) {
		Node lastNode= null;
		ConvertNode(root, lastNode);
		
		while(lastNode!=null && lastNode.left!=null)
		 lastNode = lastNode.left;
		
		return lastNode;
	}
	
	Node BToDLL(Node root)
    {
		Node lastNode= null;
		ConvertNode(root, lastNode);
		
		while(lastNode!=null && lastNode.left!=null)
		 lastNode = lastNode.left;
		
		return lastNode;
    }
	
	
	private void ConvertNode(Node node, Node lastNode) {
		
		if(node==null){
			return;
		}
			
			Node currentNode = node;
			
			if(currentNode.left!=null){
				ConvertNode(currentNode.left, lastNode);
			}
			
			currentNode.left = lastNode;
			if(lastNode!=null){
				lastNode.right = currentNode;
			}
			lastNode = currentNode;
			
			if(currentNode.right!=null){
				ConvertNode(currentNode.right,lastNode);
				
			}
		}
		
	


	class Node {
		
		 Node left;
		 Node right;
		 int data;
		 
		
		public Node(){}
		
		public Node(int data)
		{
			this.data=data;
		}
		
	}

}


