package hacker.crackingcodinginterview;

import java.util.Scanner;
import java.util.Stack;


public class TwoStacksQueueTest
{
    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue<T> {
        Stack<T> pushStack = new Stack<T>();
        Stack<T> popStack = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
           pushStack.push(value);
        }

        public T peek() {
            if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }

        public T dequeue() {
            if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }
    }

    
    

}