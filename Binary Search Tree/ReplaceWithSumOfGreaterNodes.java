public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

    public static int replace(BinaryTreeNode<Integer> root, int sum){
        if(root == null)
            return sum;
        
        
        sum = replace(root.right,sum);
        sum += root.data;
        root.data = sum;
        sum = replace(root.left, sum);
        return sum;
    }
    
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
        int sum = 0;
        replace(root,sum);
	}
}
