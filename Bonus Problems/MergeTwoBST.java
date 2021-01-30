import java.util.*;

public class solution {
    
    public static ArrayList<Integer> inOrderTraversal(BinaryTreeNode<Integer> root){
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> left = inOrderTraversal(root.left);
        
        if(left != null){
            left.add(root.data);
            
            ArrayList<Integer> right = inOrderTraversal(root.right);
            
            for(int i = 0; i < right.size(); i++){
                left.add(right.get(i));
            }
            
            return left;
        }else{
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.data);
            
            ArrayList<Integer> right = inOrderTraversal(root.right);
            
            for(int i = 0; i < right.size(); i++){
                ans.add(right.get(i));
            }
            
            return ans;
        }
    }
    
    public static void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> output){
        int m = arr1.size();
        int n = arr2.size();
        
        int i = 0;
        int j = 0;
        
        while(i < m && j < n){
            if(arr1.get(i) <= arr2.get(j)){
                output.add(arr1.get(i));
                i++;
            }else {
                output.add(arr2.get(j));
                j++;
            }
        }
        
        if(i < m){
            for(int k = i; k < m; k++){
                output.add(arr1.get(k));
            }
        }
        
        if(j < n){
            for(int k = j; k < n; k++){
                output.add(arr2.get(k));
            }
        }
    }
    
    public static BinaryTreeNode<Integer> buildTree(ArrayList<Integer> arr, int si, int ei){
        if(si > ei){
            return null;
        }
        
        int mid = (si + ei) / 2;
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr.get(mid));
        root.left = buildTree(arr,si,mid - 1);
        root.right = buildTree(arr,mid + 1, ei);
        
        return root;
    }
    
    public static void inOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        System.out.print(root.data + " ");
		inOrder(root.right);
    }
    
	static void printMergeTrees(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2) {
		
        ArrayList<Integer> order1 = inOrderTraversal(root1);
        ArrayList<Integer> order2 = inOrderTraversal(root2);
        ArrayList<Integer> order3 = new ArrayList<Integer>();
        
        merge(order1,order2,order3);
        
        BinaryTreeNode<Integer> ans = buildTree(order3,0,order3.size() - 1);
        
        inOrder(ans);
        
	}

}
