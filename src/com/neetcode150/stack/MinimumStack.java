package com.neetcode150.stack;

import java.util.Stack;

/**
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack
 * Each function should run in O(1) time.
 *
 * */

public class MinimumStack {
    int min;
    Stack<Integer> stack;

    public MinimumStack() {
        stack = new Stack<>();
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.push(0);
            min  = val;
        } else {
            stack.push(val - min);
            if( val < min) min = val;
        }
    }

    public void pop(){
        if(stack.isEmpty()) return;
        int pop = stack.pop();
        if( pop < 0) min = min - pop;
    }

    public int top(){
        int top = stack.peek();
        if (top < 0){
            return top + min;
        } else {
            return min;
        }
    }

    public int getMin(){
        return min;
    }
}
