package main.java.howard.edu.ood.hw2.collections;

import java.util.NoSuchElementException;

/**
 * Created by Prashant Bhandari on 3/8/17.
 * This class is a implementation of Queue data structure in Array
 */
public class ArrayQueue implements QueueOperations {

    private int[] queue;
    private int head;
    private int tail;
    private int queueAllocatedSize = 5;
    private int noOfElements = 0;

    public ArrayQueue() {
        queue = new int[queueAllocatedSize];
        head = -1;
        tail = -1;
    }

    /**
     * This method removes the first element of the queue array.
     * @return 0
     */
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        head = (head+1)%queueAllocatedSize;
        noOfElements -= 1;
        return 0;
    }

    /**
     * This method add element to the queue.
     * @param element an integer that is to be added to the queue.
     */
    @Override
    public void enqueue(int element) {
        if (isEmpty()) {
            tail = head = 0;
        }
        else if (isFull()) {
            resizeQueue();
            tail = (tail + 1) % queueAllocatedSize;
        }
        else {
            tail = (tail + 1) % queueAllocatedSize;
        }
        queue[tail] = element;
        noOfElements += 1;
    }

    /**
     * This method check if the queue is empty or not
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    /**
     * This method returns the head of the queue
     * @return int at front of the queue
     * @exception throws if the queue is empty
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is Empty");
        }
        return queue[head];
    }

    /**
     * This method checks if the queue is full.
     * @return true if full
     */
    private boolean isFull() {
        return (head == ((tail + 1) % queueAllocatedSize));
    }

    /**
     * This method creates a new queue if the initial queue runs out of space.
     * the new queue will be double the size of the old queue.
     * @return nothing
     */
    private void resizeQueue() {
        int index = head;
        int counter = 0;
        int[] newQueue = new int[queueAllocatedSize*2];
        while (counter<noOfElements) {
            newQueue[counter] = queue[index];
            index = (index+1)%queueAllocatedSize;
            counter++;
        }
        queue = newQueue;
        queueAllocatedSize *= 2;
        head = 0;
        tail = noOfElements-1;
    }

    /**
     * This method creates a string from the queue.
     * @return string
     *
     * sample return string:
     * front [ ] back       (empty queue)
     * front [ 1 ] back     (queue with one element)
     * front [ 5 2 8 ] back (queue with 3 elements)
     */
    public String toString() {
        if(isEmpty()){
            return "front [ ] back       (empty queue)";
        }
        else {
            StringBuilder sb = new StringBuilder();
            int index = head;
            int counter = 0;
            while(counter<noOfElements){
                sb.append(" ");
                sb.append(queue[index]);
                index = (index+1)%queueAllocatedSize;
                counter++;
            }
            sb.append(" ");
            if (noOfElements == 1){
                return "front [" + sb.toString() + "] back       (queue with one element)";
            }
            return "front [" + sb.toString() + "] back       (queue with " + String.valueOf(noOfElements) + " elements)";
        }
    }
}


