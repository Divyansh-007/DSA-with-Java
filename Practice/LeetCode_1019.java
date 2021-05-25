/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        ListNode temp = head;
        
        while(temp != null){
            nodes.add(temp.val);
            temp = temp.next;
        }
        
        int ans[] = new int[nodes.size()];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < ans.length; i++){
            while(!st.isEmpty() && nodes.get(st.peek()) < nodes.get(i)){
                ans[st.pop()] = nodes.get(i);
            }
            
            st.push(i);
        }
        
        
        return ans;
    }
}
