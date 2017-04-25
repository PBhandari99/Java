package main.java;

/**
 * Created by ${PrashantBhandari} on ${3/8/17}.
 */

public interface StackOperations {
    // Push an item onto the stack
    public void push(int item);
    // Pop an item off the stack
    public int pop();
    // Return the top item from the stack
    public int peek();
    // Return true if empty, otherwise false
    public boolean isEmpty();
}
