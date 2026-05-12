class MinStack {
    ArrayDeque<Integer> minStack;

    public MinStack() {
     this.minStack = new ArrayDeque<>();   
    }
    
    public void push(int val) {
        minStack.push(val);
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : minStack) {
            queue.offer(i);
        }
        return queue.peek();
    }
}
