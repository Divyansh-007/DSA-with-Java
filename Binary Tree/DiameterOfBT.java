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

class Pair {

    int diameter;
    int height;

    public Pair(int diameter,int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

public class Solution {

    // to find height and diameter of a tree
    public static Pair heightAndDia(BinaryTreeNode<Integer> root){
        if(root == null) {
            // int height = 0;
            // int diameter = 0;
            Pair ans = new Pair(0,0);
            return ans;
        }

        Pair leftOutput = heightAndDia(root.left);
        Pair rightOutput = heightAndDia(root.right);

        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        int option1 = leftOutput.height + rightOutput.height+1;
        int option2 = leftOutput.diameter;
        int option3 = rightOutput.diameter;

        int diameter =  Math.max(option1, Math.max(option2, option3));
        //  Pair ans = new Pair(height, diameter);

        return(new Pair(diameter,height));
    }

    // main funtion to find diameter
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here
        Pair pair=heightAndDia(root);
        return pair.diameter;
    }
}
