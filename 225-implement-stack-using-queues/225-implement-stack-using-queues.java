class MyStack {

    Queue<Integer> q;
    public MyStack() 
    {
       q = new LinkedList<>();
    }
    
    public void push(int x) // TC O(N) , SC O(1)
    {
        q.add(x);
        for(int i = 1; i < q.size(); i++)
            q.add(q.poll());
    }
    
    public int pop()  // TC O(1) , SC O(1)
    {
        return q.poll();
    }
    
    public int top() // TC O(1) , SC O(1)
    {
        return q.peek();
    }
    
    public boolean empty() // TC O(1) , SC O(1)
    {
        return q.isEmpty();
        
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