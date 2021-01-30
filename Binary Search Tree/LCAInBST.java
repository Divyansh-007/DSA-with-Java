public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */


	public static BinaryTreeNode<Integer> getLCANode(BinaryTreeNode<Integer> root, int a, int b){
        if(root == null){
            return null;
        }
        
        if(root.data < a && root.data < b){
            return getLCANode(root.right,a,b);
        }
        
        if(root.data > a && root.data > b){
            return getLCANode(root.left,a,b);
        }
        
        return root;
    }
    
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if(root == null){
            return -1;
        }
        
        return getLCANode(root,a,b).data;
	}
}