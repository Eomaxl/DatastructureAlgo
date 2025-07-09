package com.stack.implementation;

/**
 * Implement a Last-In-First-Out (LIFO) stack using an array. The implemented stack should support the following operations: push, pop, peek, and isEmpty.
 *
 * Implement the ArrayStack class:
 *
 * void push(int x): Pushes element x onto the stack.
 * int pop(): Removes and returns the top element of the stack.
 * int top(): Returns the top element of the stack without removing it.
 *
 * boolean isEmpty(): Returns true if the stack is empty, false otherwise.
 *Input: ["ArrayStack", "push", "push", "top", "pop", "isEmpty"]
 * [[], [5], [10], [], [], []]
 * Output: [null, null, null, 10, 10, false]
 *
 * Explanation:
 * ArrayStack stack = new ArrayStack();
 * stack.push(5);
 * stack.push(10);
 * stack.top(); // returns 10
 * stack.pop(); // returns 10
 * stack.isEmpty(); // returns false
 * */

public class StackUsingArrays {
    private int[] stack;
    private int size;
    private final int DEFAULT_CAPACITY = 1000;

    public StackUsingArrays() {
        this.stack = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(int val){
        if(size == stack.length){
            throw new RuntimeException("Stack is full");
        }
        stack[size++] = val;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stack[--size];
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stack[size-1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays();
        stack.push(5);
        stack.push(10);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.isEmpty();
    }

}
