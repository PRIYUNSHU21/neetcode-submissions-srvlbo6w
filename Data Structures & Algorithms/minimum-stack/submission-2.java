class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min; 

    public MinStack() {
        stack = new ArrayDeque<>();
         min = new ArrayDeque<>();
    }
    
    public void push(int val) {

        stack.push(val);

        if( min.isEmpty() || min.peek() >= val)
        {
            min.push(val);
        }
        
    }
    
    public void pop() {

        if(stack.peek().equals(min.peek()))
        {
            min.pop();
        }
        stack.pop();
        
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {

       if(min.isEmpty()){ throw new EmptyStackException();}
       return min.peek();
        
    }
}
