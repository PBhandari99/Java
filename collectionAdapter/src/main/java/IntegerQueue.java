package main.java;

import java.util.*;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */
public class IntegerQueue implements QueueOperations{

    private LinkedList<Integer> queueList;

    public IntegerQueue() {
        queueList = new LinkedList<>();
    }

    // Remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queueList.removeFirst();
    }

    // Place an element on the queue
    public void enqueue(int element) {
        queueList.add(element);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    // Return element at head of queue but don’t remove it.
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queueList.peek();
    }

    public String toString() {
        if(isEmpty()){
            return "front [ ] back       (empty queue)";
        }
        else {
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            while(counter<queueList.size()){
                sb.append(" ");
                sb.append(queueList.get(counter));
                counter++;
            }
            sb.append(" ");
            if (queueList.size() == 1){
                return "front [" + sb.toString() + "] back       (queue with one element)";
            }
            return "front [" + sb.toString() + "] back       (queue with " + String.valueOf(queueList.size()) + " elements)";
        }
    }
}
