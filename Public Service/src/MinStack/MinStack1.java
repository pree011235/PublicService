package MinStack;
import java.util.*;
/*
 * The classic minstack problem where push, pop, top and getMin 
 * all run in O(1) time
 * We also examine the variations of this problem
 */
class MinStack1 {
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> actualStack = new Stack<Integer>();
    int currMin = 0;
    
    public void push(int x) {
        if(x < Integer.MIN_VALUE || x > Integer.MAX_VALUE)
            return;
        else{
            if(minStack.isEmpty() && actualStack.isEmpty()){
                minStack.push(x);
                actualStack.push(x);
            }else{
                actualStack.push(x);
                if(x <= minStack.peek()) 
                    minStack.push(x);
                }
            }    
    }

    public void pop() {
        if(!actualStack.isEmpty()){
            int popped = actualStack.pop();
            if(minStack.peek() == popped)
                minStack.pop();
        }
    }

    public int top() {
        int topEl = 0;
        if(!actualStack.isEmpty())
            topEl = actualStack.peek();
        return topEl;    
    }

    public int getMin() {
        if(!minStack.isEmpty())
            return minStack.peek();
        return 0;    
    }
}
