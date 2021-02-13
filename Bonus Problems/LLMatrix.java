import java.util.ArrayList;

/*
class Node{
    int data;
    Node right,down;
    Node(int data){
        this.data=data;
        right=null;
        down=null;
    }
}
*/
public class Solution{
    static Node construct(int arr[][],int n)
    {
        //Add your code here.
        ArrayList<Node> rowLLHeads = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            Node head = null;
            Node tail = null;
            for(int j = 0; j < n; j++){
                Node newNode = new Node(arr[i][j]);
                if(head == null){
                    head = newNode;
                    tail = newNode;
                }else{
                    tail.right = newNode;
                    tail = tail.right;
                }
            }
            rowLLHeads.add(head);
        }
        
        for(int k = 0; k + 1 < n; k++){
            Node LL1 = rowLLHeads.get(k);
            Node LL2 = rowLLHeads.get(k + 1);
            
            while(LL1 != null && LL2 != null){
                LL1.down = LL2;
                LL1 = LL1.right;
                LL2 = LL2.right;
            }
        }
        
        return rowLLHeads.get(0);
       
    }

}
