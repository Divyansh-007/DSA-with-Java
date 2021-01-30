/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {
    
    public static void depthReplacement(BinaryTreeNode<Integer> root, int level) {
		if(root == null) {
			return;
		}
		
		root.data = level;
		
		depthReplacement(root.left, level + 1);
		depthReplacement(root.right, level + 1);		
	}

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
        depthReplacement(root,0);
	}

}
