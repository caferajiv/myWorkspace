package hacker.crackingcodinginterview;

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  
The Node class is defined as follows:
*/



public class CheckBST
{
	class Node
	{
	    int data;
	    Node left;
	    Node right;
	} 
	
    boolean checkBST (Node root)
    {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        boolean isTrue = (root.left.data < root.data && root.right.data > root.data);
        int left = getMaxOfLeftSubtree(root.left);
        int right = getMinOfRightSubtree(root.right);
        return (isTrue && left < root.data && right > root.data && checkBST(root.left) && checkBST(root.right));

    }

    private int getMinOfRightSubtree (Node root)
    {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root != null && root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int getMaxOfLeftSubtree (Node root)
    {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root != null && root.right != null) {
            root = root.right;
        }
        return root.data;
    }}
