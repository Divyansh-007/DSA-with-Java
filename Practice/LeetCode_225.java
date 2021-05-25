class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() != 1){
            q2.add(q1.peek());
            q1.remove();
        }
        
        int temp = q1.peek();
        q1.remove();
        
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        while(q1.size() != 1){
            q2.add(q1.peek());
            q1.remove();
        }
        
        int temp = q1.peek();
        q1.remove();
        q2.add(temp);
        
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        
        return temp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
