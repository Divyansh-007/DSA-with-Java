public class Solution {

    /*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

    /*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */

    public static class HeadAndTail<T> {
        LinkedListNode<T> head;
        LinkedListNode<T> tail;

        public HeadAndTail(LinkedListNode<T> head, LinkedListNode<T> tail) {
            this.head = head;
            this.tail = tail;
        }

    }


    // BST to a sorted LL helper
    public static HeadAndTail<Integer> returnHeadTail(BinaryTreeNode<Integer> root){
        if(root == null) {
            return new HeadAndTail<>(null, null);
        }

        HeadAndTail<Integer> leftAns = returnHeadTail(root.left);
        HeadAndTail<Integer> rightAns = returnHeadTail(root.right);
        LinkedListNode<Integer> rootHead = new LinkedListNode<Integer>(root.data);
        LinkedListNode<Integer> finalHead = null, finalTail = null;

        if(leftAns.head != null){
            leftAns.tail.next = rootHead; 
            finalHead = leftAns.head;
        }else{
            finalHead = rootHead;
        }

        if(rightAns.head != null){
            rootHead.next = rightAns.head;
            finalTail = rightAns.tail;
        }else{
            finalTail = rootHead;
        }

        HeadAndTail<Integer> ans = new HeadAndTail<Integer>(finalHead,finalTail);
        return ans;
    }

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        return returnHeadTail(root).head;
    }
}
