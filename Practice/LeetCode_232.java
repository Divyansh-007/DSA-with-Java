class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(s1.size() != 1){
            s2.push(s1.pop());
        }
        
        int temp = s1.peek();
        s1.pop();
        
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
        return temp;
    }
    
    /** Get the front element. */
    public int peek() {
        while(s1.size() != 1){
            s2.push(s1.pop());
        }
        
        int temp = s1.peek();
        
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
        return temp;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
