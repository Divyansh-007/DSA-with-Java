/*
	Following is the structure of the node class for a Singly Linked List

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

*/

public class Queue {

    //Define the data members
    private Node front;
    private Node rear;
    private int size;


    public Queue() {
        //Implement the Constructor
        front = null;
        rear = null;
        size = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return size;
    } 


    public boolean isEmpty() { 
        //Implement the isEmpty() function
        return size==0;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function
        Node newNode = new Node(data);
        size = size + 1;
        
        if(front == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }


    public int dequeue() {
        //Implement the dequeue() function
        if(isEmpty()) {
			return -1;
		}
		
		int temp = front.data;
		front = front.next;
       
        size = size - 1;
		return temp;
	}


    public int front() {
        //Implement the front() function
        if(isEmpty()) {
			return -1;
		}
		
		return front.data;
    }
}
