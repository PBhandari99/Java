package main.java;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */

public interface QueueOperations {
    // Remove an element from the queue
    public int dequeue();
    // Place an element on the queue
    public void enqueue(int  element);
    // Check if the queue is empty
    public boolean isEmpty();
    // Return element at head of queue but don’t remove it.
    public int peek();

}
