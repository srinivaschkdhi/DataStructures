package stacks;

import java.util.Stack;

class MinStack2 {
    int min;
    Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MinStack2() {
       stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            min = x;
        }else if(x <= min){
            stack.push(2 * x - min);
            min = x;
        }else{
            stack.push(x);
        }
    }
    
    public void pop() {
      if(stack.peek() > min){
           stack.pop();
      }else{
          min = 2 * min - stack.peek();
           stack.pop();
      }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */