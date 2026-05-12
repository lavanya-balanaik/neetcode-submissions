// class MinStack {
//     ArrayDeque<Integer> minStack;
//     PriorityQueue<Integer> queue = new PriorityQueue<>();

//     public MinStack() {
//      this.minStack = new ArrayDeque<>();
//     }
    
//     public void push(int val) {
//         minStack.push(val);
//         queue.offer(val);
//     }
    
//     public void pop() {   
//         queue.remove(minStack.peek());
//         minStack.pop();
//     }
    
//     public int top() {
//         return minStack.peek();
//     }
    
//     public int getMin() {
//         // PriorityQueue<Integer> queue = new PriorityQueue<>();
//         // for(int i : minStack) {
//         //     queue.offer(i);
//         // }
//         return queue.peek();
//     }
// }

//Optimal Solution
class MinStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


