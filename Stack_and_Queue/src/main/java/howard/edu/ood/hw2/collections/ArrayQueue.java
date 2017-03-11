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

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        head = (head+1)%queueAllocatedSize;
        noOfElements -= 1;
        return 0;
    }

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

    @Override
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is Empty");
        }
        return queue[head];
    }

    private boolean isFull() {
        return (head == ((tail + 1) % queueAllocatedSize));
    }

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

    public String toString() {
        if(isEmpty()){
            return "front [ ] back       (empty queue)";
        }
        else {
            StringBuilder sb = new StringBuilder();
            int index = head;
            int counter = 0;
            while(counter<noOfElements){  // head = head; head!=tail; head=(head+1)%queueAllocatedsize
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


