package hacker.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
	
	
	void preOrder(Node root) {
		if(root!=null){
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
			
		}

	}
	
	void postOrder(Node root) {
		
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
			
			
		}

	}
	
	void inOrder(Node root) {

		if(root!=null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	int height(Node root)
    {
		int maxNodes = findHeight(root);
		return maxNodes -1;
		
    }
	
	private int findHeight(Node root){
		if(root==null){
			return 0;
		}
		return 1+ Math.max(findHeight(root.left),findHeight(root.right));
	}
	
	void LevelOrder(Node root)
    {
		 Queue q = new LinkedList();
      if(root!=null){
    	  q.offer(root);
      }
      
      while(!q.isEmpty()){
    	  Node node = (Node)q.remove();
    	  System.out.print(node.data+ " ");
    	  if(node.left!=null){
    		  q.offer(node.left);
    	  }
    	  if(node.right!=null){
    		  q.offer(node.right);
    	  }
      }
      
    }
	
	static Node Insert(Node root,int value)
    {
		if(root!=null){
			insertNode(root, value);
			
		}else {
			Node node = new Node();
			node.data = value;
			root = node;
		}

       return root;
    }
	
	private static void insertNode(Node root, int value) {
		if(root!=null){	
		if(value<=root.data){
			if(root.left!=null){
			insertNode(root.left, value);
			}else{
				Node node = new Node();
				node.data= value;
				root.left=node;
			}
		}else{
			if(root.right!=null){
			insertNode(root.right, value);
			}else {
				Node node = new Node();
				node.data = value;
				root.right = node;
			}
		}
		}
		
	}
	
	void decode(String S ,Node root)
    {
        char[] charArray = S.toCharArray();
        int length = S.length();
        int i=0;
        Node temp = root;
        while(i<length){
        	if(charArray[i]=='0'){
        		temp = temp.left;
        		if(isLeaf(temp)){
        			System.out.print(temp.data);
        			temp = root;
        			
        		}
        		i++;
        	}else if(charArray[i]=='1'){
        		temp = temp.right;
        		if(isLeaf(temp)){
        			System.out.print(temp.data);
        			temp = root;
        			
        		}
        		i++;
        	}
        	
        }
        

       
    }

	private boolean isLeaf(Node root) {
		if(root.left==null && root.right==null){
			return true;
		}
		return false;
	}
	
	
	static Node lca(Node root,int v1,int v2)
    {
		if(root!=null){
			if((v1< root.data && v2>root.data) || (v2< root.data && v1>root.data) ){
				return root;
			}else if(v1<root.data && v2<root.data){
				return lca(root.left, v1,v2);
			}else if(v1>root.data && v2>root.data){
				return lca(root.right, v1,v2);
			}
		}
		

		return root;
       
    }
	
	
boolean checkBST(Node root) {
	if(root==null) return true;
	if(root.left==null && root.right==null) return true;
	
	if(MaxValueinLeftSubtree(root)<root.data && MinValueinRightSubtree(root) > root.data){
		return checkBST(root.left) && checkBST(root.right);
	}
	return false;
        
    }

	private int MinValueinRightSubtree(Node root) {
	while(root.left!=null){
		root = root.left;
	}
	return root.data;
}

	private int MaxValueinLeftSubtree(Node root) {
		while(root.right!=null){
			root = root.right;
		}
		return root.data;
}










	static class Node {
		  int data;
		    Node left;
		    Node right;
		    public  int frequency; // the frequency of this tree
		       //public  char data;
		       
	    Node(){
	   	 
	    }
	    
	 }



}





