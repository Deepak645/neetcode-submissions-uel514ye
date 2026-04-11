class MinStack {

    Deque<Integer> stack=new ArrayDeque<>();
    Deque<Integer> minStack=new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {

        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()>=val) minStack.push(val);

        
    }
    
    public void pop() {        
        if(minStack.peek().equals(stack.peek())) minStack.pop();
       
        stack.pop();
    }
    
    public int top() {

        return stack.peek();
        
    }
    
    public int getMin() {

        return minStack.peek();
        
    }
}
