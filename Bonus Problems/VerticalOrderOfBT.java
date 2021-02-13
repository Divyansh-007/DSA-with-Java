// import java.util.TreeMap;
// import java.util.Vector;
// import java.util.Map.Entry;
import java.util.*;

public class Solution {

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

    public static void getVerticalOrder(BinaryTreeNode<Integer> root, int order,HashMap<Integer,Vector<Integer>> map)
    {
        if(root == null){
            return;
        }

        Vector<Integer> get =  map.get(order);
         
        if(get == null)
        {
            get = new Vector<>();
            get.add(root.data);
        }
        else{
            get.add(root.data);
        }
            
        map.put(order, get);
        
        getVerticalOrder(root.left, order-1, map);
        getVerticalOrder(root.right, order+1, map);
    }
    
	public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root){
		/* Your class should be named Solution 
		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
        
        HashMap<Integer,Vector<Integer>> map = new HashMap<>();
        getVerticalOrder(root,0,map);
         
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            Vector<Integer> curr = map.get(key);
            Enumeration enu = curr.elements();
            while (enu.hasMoreElements()) { 
            	System.out.print(enu.nextElement() + " "); 
        	}
            System.out.println();
        }
	}



}
