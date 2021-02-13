import java.util.ArrayList;

class Pair{
    int depth;
    int parent;
    
    Pair(int depth,int parent){
        this.depth = depth;
        this.parent = parent;
    }
}
public class solution {

	/*	Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	 */

    public static Pair depthAndParent(BinaryTreeNode<Integer> root, int data, int level, int parent){
        if(root == null){
            return new Pair(0,-1);
        }
        
        if(root.data == data){
            return new Pair(level,parent);
        }
        
        Pair leftAns = depthAndParent(root.left,data,level + 1,root.data);
        
        if(leftAns.depth != 0){
            return leftAns;
        }
         
        return depthAndParent(root.right,data,level + 1,root.data);
    }
    
	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		// Write your code here
        if(root == null){
            return false;
        }
        
        Pair pAns = depthAndParent(root,p,0,root.data);
        Pair qAns = depthAndParent(root,q,0,root.data);
        
        if(pAns.depth != qAns.depth){
            return false;
        }else{
            return pAns.parent != qAns.parent;
        }

	}
}
