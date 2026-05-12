class MinStack {
    ArrayDeque<Integer> minStack;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public MinStack() {
     this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        minStack.push(val);
        queue.offer(val);
    }
    
    public void pop() {   
        queue.remove(minStack.peek());
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        // for(int i : minStack) {
        //     queue.offer(i);
        // }
        return queue.peek();
    }
}
