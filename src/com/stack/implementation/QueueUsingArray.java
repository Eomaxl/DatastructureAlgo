package com.stack.implementation;

public class QueueUsingArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private final int DEFAULT_MAX_SIZE  = 100;

    public QueueUsingArray() {
        this.queue = new int[DEFAULT_MAX_SIZE];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void enqueue(int val){
        if(size == queue.length){
            throw new RuntimeException("Queue is full");
        }
        queue[rear] = val;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int val = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return val;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args){
        QueueUsingArray queue = new QueueUsingArray();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }
}
