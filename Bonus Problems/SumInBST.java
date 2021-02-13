import java.util.*;

public class Solution {
    
    public static ArrayList<Integer> inorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> left = inorder(root.left);
        
        if(left != null){
            left.add(root.data);
            
            ArrayList<Integer> right = inorder(root.right);
            
            for(int i = 0; i < right.size(); i++){
                left.add(right.get(i));
            }
            
            return left;
        }else{
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.data);
            
            ArrayList<Integer> right = inorder(root.right);
            
            for(int i = 0 ; i < right.size(); i++){
                ans.add(right.get(i));
            }
            
            return ans;
        }
    }
    
	public static int ksmallestElementSum(BinaryTreeNode<Integer> root, int k) {
		/*
		 * Your class should be named Solution.Don't write main().Don't take
		 * input, it is passed as function argument.Don't print output.Taking
		 * input and printing output is handled automatically.
		 */
        ArrayList<Integer> inOrder = inorder(root);
        int sum = 0;
        
        for(int i = 0; i < k; i++){
            sum = sum + inOrder.get(i);
        }
        
        return sum;

	}

}
