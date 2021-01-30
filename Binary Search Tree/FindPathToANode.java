import java.util.ArrayList;

public class Solution {

    /*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 * 		public BinaryTreeNode(T data) 
	 * 		{ 
	 * 			this.data = data; 
	 * 		}
	 * }
	 */

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
        /* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        if(root == null){
            return null;
        }

        if(root.data == data){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }

        if(root.data > data){
            ArrayList<Integer> leftPath = getPath(root.left,data);
            if(leftPath != null){
                leftPath.add(root.data);
                return leftPath;
            }
        }else if(root.data < data){
            ArrayList<Integer> rightPath = getPath(root.right,data);
            if(rightPath != null){
                rightPath.add(root.data);
                return rightPath;
            }
        }
        
        return null;
    }
}
