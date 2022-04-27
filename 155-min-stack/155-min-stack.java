class MinStack {

    PriorityQueue<Integer> priorityQueue;
    Stack<Integer> stack;
    public MinStack() {
        this.priorityQueue = new PriorityQueue<>();
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        priorityQueue.add(val);
        stack.push(val);
    }
    
    public void pop() {
        int value = stack.pop();
        priorityQueue.remove(value);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return priorityQueue.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */