package com.learning.algorithms.stack;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 */
public class QueueViaTwoStack<T>{
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public T poll(){
        if (stack2.isEmpty() && stack1.isEmpty())
            throw new RuntimeException("Queue is empty!");
        moveElements();
        return stack2.pop();

    }

    public T peek(){
        if (stack2.isEmpty() && stack1.isEmpty())
            throw new RuntimeException("Queue is empty!");
        moveElements();
        return stack2.peek();
    }

    private void moveElements(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public void offer(T value){
        stack1.push(value);
    }

    public static void main(String[] args) {
        QueueViaTwoStack<Integer> queue = new QueueViaTwoStack<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
